# 02 - Drug Overdose Data Mining and Predictive Analytics

## Abstract
This project applies data mining techniques to a public health dataset containing accidental drug-related death records. Drug overdose remains a serious public health issue, and analysing overdose data can help identify patterns in opioid involvement, substance trends, geographic hotspots, and unusual overdose cases. The dataset used in this project contained demographic, geographic, and substance-related features, making it suitable for applying multiple data mining methods.

The purpose of this project was to explore how classification, regression, clustering, and anomaly detection could be used to extract meaningful insights from overdose death data. Random Forest and Support Vector Machine were used for classification, Linear Regression and Polynomial Regression were used for trend modelling, K-Means and DBSCAN were applied for geographic clustering, and Isolation Forest and Local Outlier Factor were used for anomaly detection.

The project involved data cleaning, feature engineering, preprocessing, model training, algorithm comparison, validation, and visualisation. Evaluation methods included confusion matrices, ROC/AUC analysis, regression metrics, clustering evaluation, and anomaly interpretation. Overall, this project demonstrates practical experience in machine learning, data mining, public health analytics, model comparison, and insight generation from complex real-world datasets.

## Problem Statement
Drug overdose deaths involve many interacting factors, including demographic background, location, substance combinations, and time-based trends. Without structured data analysis, it can be difficult to identify which cases involve opioids, how substance involvement changes over time, where overdose hotspots occur, and which cases appear unusual.

This project addresses the need for data-driven analysis to support public health understanding, prevention strategies, and resource allocation.

## Objectives
To preprocess and clean a real-world accidental drug-related deaths dataset.
To classify whether overdose deaths involved opioids using machine learning models.
To analyse substance involvement trends over time using regression models.
To identify geographic overdose hotspots using clustering techniques.
To detect unusual overdose cases using anomaly detection algorithms.
To compare multiple algorithms and evaluate their strengths and weaknesses.

## Dataset / Input
The dataset used in this project was an accidental drug-related deaths dataset from the Connecticut Office of the Chief Medical Examiner. It contained records from 2012 to 2023 and included demographic, geographic, and substance-related attributes.

The dataset included information such as:

Age
Sex
Race
Ethnicity
Residence location
Injury location
Death location
Geographic coordinates
Substance involvement columns
Cause and manner of death

The dataset required preprocessing before modelling, including cleaning inconsistent values, standardising categories, handling missing data, transforming variables, extracting geographic coordinates, encoding categorical variables, and selecting relevant features.

## Methodology
1. Data Collection
The public health dataset was obtained and reviewed to understand its structure, attributes, and analytical potential.
2. Data Cleaning
Inconsistent values, typographical errors, missing entries, whitespace issues, and fragmented categories were cleaned and standardised.
3. Data Transformation
Categorical features were encoded, numerical features were prepared, and selected variables were transformed for modelling.
4. Feature Engineering
Relevant features were created or selected for classification, regression, clustering, and anomaly detection tasks.
5. Classification
Random Forest and Support Vector Machine were used to classify opioid involvement in overdose deaths.
6. Regression
Linear Regression and Polynomial Regression were used to analyse substance trend changes over time.
7. Clustering
K-Means and DBSCAN were applied to identify geographic overdose hotspots.
8. Anomaly Detection
Isolation Forest and Local Outlier Factor were used to detect unusual overdose cases.
9. Evaluation
Models were evaluated using confusion matrices, cross-validation, ROC/AUC analysis, regression metrics, clustering metrics, and visual comparison.
10. Results Interpretation
The findings were interpreted in relation to public health decision-making, hotspot detection, prevention strategies, and early identification of unusual cases.

## Technologies Used
Python
pandas
NumPy
scikit-learn
Matplotlib
Seaborn
Random Forest
Support Vector Machine
Linear Regression
Polynomial Regression
K-Means
DBSCAN
Isolation Forest
Local Outlier Factor
Confusion matrix
ROC/AUC analysis
Cross-validation
Data visualisation

## Results

The project produced insights across four major data mining areas:

Classification: Used machine learning models to classify opioid involvement.
Regression: Modelled substance involvement trends over time.
Clustering: Identified geographic overdose hotspot patterns.
Anomaly Detection: Detected unusual cases that may represent rare substance combinations, emerging threats, or atypical demographic/geographic patterns.

Key findings:

Random Forest and SVM were useful for comparing classification performance.
Regression models helped explain changing substance trends over time.
K-Means and DBSCAN provided different approaches to hotspot detection.
Isolation Forest and LOF helped identify unusual overdose cases.
Visualisation was important for interpreting results beyond raw model scores.

Add final accuracy, AUC, RMSE, clustering score, anomaly plots, or strongest model result here if available.

## Screenshots / Visualisations

Suggested visuals to add:

Confusion matrix comparison
ROC curve
Regression trend graph
K-Means cluster map
DBSCAN cluster map
Anomaly detection scatter plot
Feature importance chart
Drug co-occurrence heatmap
Yearly overdose trend chart

## Key Learnings
Learned how different data mining techniques apply to different problem types.
Gained experience comparing multiple algorithms for the same analytical task.
Understood the importance of preprocessing in real-world datasets.
Learned how classification, regression, clustering, and anomaly detection can support public health analytics.
Improved ability to interpret machine learning results in a real-world context.
Learned that model performance must be explained alongside practical implications.

## Limitations
The dataset may contain missing, inconsistent, or incomplete records.
Geographic coordinates may not fully capture the complexity of overdose events.
Correlation or prediction does not prove direct causation.
Some rare substances or categories may have too few records for strong modelling.
Public health data can be sensitive and must be interpreted carefully.
Models trained on one regional dataset may not generalise to other locations.

## Future Improvements
Add more recent data if available.
Include external variables such as socioeconomic indicators, healthcare access, or policy changes.
Use advanced geospatial analysis for hotspot detection.
Test additional models such as XGBoost, LightGBM, or neural networks.
Build an interactive dashboard for public health insights.
Improve interpretability using SHAP or feature importance analysis.
Deploy the analysis as a Streamlit dashboard or web-based public health analytics tool.

## How to Run
pip install -r requirements.txt
python main.py

If using notebooks:

jupyter notebook drug_overdose_data_mining.ipynb
