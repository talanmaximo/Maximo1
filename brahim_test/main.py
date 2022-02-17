import dagshub
import pandas as pd
from sklearn import preprocessing
from sklearn.linear_model import SGDClassifier
from sklearn.preprocessing import MinMaxScaler
from sklearn.linear_model import LogisticRegression 
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import (
    roc_auc_score,
    average_precision_score,
    accuracy_score,
    precision_score,
    recall_score,
    f1_score,
)
from sklearn.model_selection import train_test_split
import joblib
import numpy as np


drop_cols = ["age", "diabetes", "Oxygene", "sex","smoking","Heart_Disease"]
obj_col = "DEATH_EVENT"
train_df_path = "Data/h2.csv"
test_df_path = "Data/TestReal.csv"
sub_df_path = "Data/sample_submission.csv"

def feature_engineering(raw_df):
    df = raw_df.copy()
    scaler = MinMaxScaler()
    df=scaler.fit_transform(df)
    
    return df

def fit_model(train_X, train_y, random_state=42):
    
    clf = LogisticRegression(max_iter=1000) 
    clf.fit(train_X,train_y) 

    
    return clf


def eval_model(clf, X, y):
    y_proba = clf.predict_proba(X)[:, 1]
    y_pred = clf.predict(X)
    return {
        "roc_auc": roc_auc_score(y, y_proba),
        "average_precision": average_precision_score(y, y_proba),
        "accuracy": accuracy_score(y, y_pred),
        "precision": precision_score(y, y_pred),
        "recall": recall_score(y, y_pred),
        "f1": f1_score(y, y_pred),
    }

def submission(clf, X , sub_file):
    sub = pd.read_csv(sub_file)
    sub[obj_col] = clf.predict(X)
    sub.to_csv("Submission/submission.csv", index=False)



def train():
    print("Loading data...")
    df_train = pd.read_csv(train_df_path,sep = ";")
    df_test = pd.read_csv(test_df_path )
    
    print("Engineering features...")
    y = df_train[obj_col]
    X = feature_engineering(df_train)[: , :-1]
    test_df = feature_engineering(df_test)
    #X, test_df = to_category(X, test_df)
    """X.fillna(0, inplace=True)
    test_df.fillna(0, inplace=True)"""
    with dagshub.dagshub_logger() as logger:
        print("Training model...")
        X_train, X_test, y_train, y_test = train_test_split(
            X, y, test_size=0.33, random_state=42, stratify=y
        )
        print(X_train.shape)
        model = fit_model(X_train, y_train)
        print("Saving trained model...")
        joblib.dump(model, "Model/model.joblib")
        logger.log_hyperparams(model_class=type(model).__name__)
        logger.log_hyperparams({"model": model.get_params()})
        print("Evaluating model...")
        train_metrics = eval_model(model, X_train, y_train)
        print("Train metrics:")
        print(train_metrics)
        logger.log_metrics({f"train__{k}": v for k, v in train_metrics.items()})
        test_metrics = eval_model(model, X_test, y_test)
        print("Test metrics:")
        print(test_metrics)
        logger.log_metrics({f"test__{k}": v for k, v in test_metrics.items()})
        print("Creating Submission File...")
        print("before")
        submission(model, test_df , test_df_path)
        print("after")



if __name__ == "__main__":
    train()


"""import pandas as pd
data = pd.read_csv("h2.csv" , sep  = ";")
y = data["age"]
print(y)"""