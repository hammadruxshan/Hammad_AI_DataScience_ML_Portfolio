# 04 - Statistical Modelling of Factors Influencing Student Academic Performance

## Abstract
This project investigates the factors that influence student academic performance using statistical modelling and data analysis. Academic performance can be affected by internal and external factors such as study habits, motivation, sleep, parental involvement, internet access, and technology use. Understanding these relationships can help educators and institutions design more targeted academic support strategies.

The purpose of this project was to analyse a student performance dataset and identify which variables were most strongly associated with exam outcomes. The project applied statistical techniques including Pearson correlation testing, t-tests, ANOVA, multiple linear regression, data visualisation, and regression diagnostics. These methods were used to test relationships between academic performance and behavioural, environmental, and technological factors.

The results showed that variables such as study hours, motivation, parental involvement, and internet access had meaningful relationships with student exam performance, with study habits appearing as an important predictor. The regression model was evaluated using metrics such as R², Adjusted R², RMSE, and diagnostic plots. Overall, this project demonstrates practical skills in statistical testing, regression analysis, data visualisation, model evaluation, and education-focused data interpretation.

## Problem Statement
Student academic performance is influenced by many factors, but institutions may not always know which factors have the strongest relationship with exam outcomes. Without data-driven analysis, educational interventions may become too general and fail to target the specific areas where students need support.

This project addresses the need for a statistical model that can analyse student performance factors and provide evidence-based insights for improving academic support.

## Objectives
To identify internal and external factors affecting student academic performance.
To analyse relationships between student characteristics and exam scores using statistical testing.
To apply Pearson correlation, t-tests, and ANOVA to test selected hypotheses.
To build a multiple linear regression model for predicting student performance.
To evaluate model reliability using R², Adjusted R², RMSE, and diagnostic plots.
To generate data-driven recommendations for educational support.

## Dataset / Input
The dataset used in this project was a student academic performance dataset sourced from Kaggle. It included student-related variables such as:

Study hours
Motivation level
Sleep patterns
Parental involvement
Internet access
Technology usage
Lifestyle factors
Exam scores

The dataset was used to explore how behavioural, environmental, and technological factors influence academic performance.

## Methodology
1. Data Collection
The student performance dataset was obtained from Kaggle and reviewed to understand its structure, variables, and research value.
2. Data Cleaning
The dataset was checked for missing values, inconsistent data, and unsuitable variables.
3. Exploratory Data Analysis
Data visualisations and summary statistics were used to understand variable distributions and relationships.
4. Hypothesis Formulation
Hypotheses were created to test the relationship between selected factors and academic performance.
5. Statistical Testing
Pearson correlation, t-tests, and ANOVA were applied to analyse relationships between variables.
6. Regression Modelling
Multiple linear regression was used to predict exam performance based on significant variables.
7. Model Evaluation
The model was evaluated using R², Adjusted R², RMSE, and regression diagnostic plots.
8. Results Interpretation
The findings were interpreted to understand which factors had the strongest influence on student performance.

## Technologies Used
Python or R
pandas
NumPy
Matplotlib
Seaborn
Statistical testing
Pearson correlation
t-tests
ANOVA
Multiple linear regression
Regression diagnostics
Data visualisation
Model evaluation metrics

## Results
The analysis identified several factors that were meaningfully associated with student academic performance.

## Key findings:
Study hours showed a strong relationship with exam performance.
Motivation and parental involvement were important academic support factors.
Internet access had a measurable relationship with student outcomes.
Statistical tests helped determine whether observed differences were significant.
Multiple linear regression provided a structured way to estimate exam performance.
Model evaluation using R², Adjusted R², and RMSE helped assess reliability.

Add exact R², Adjusted R², RMSE, p-values, and final charts here if available.

## Screenshots / Visualisations
Suggested visuals to add:

Correlation heatmap
Scatter plot for study hours vs exam score
Boxplot for group comparisons
ANOVA visualisation
Regression diagnostic plots
Actual vs predicted exam score graph
Feature importance or coefficient table

## Key Learnings
Learned how to apply statistical testing to real-world educational data.
Understood how Pearson correlation, t-tests, and ANOVA are used for different research questions.
Gained experience building and interpreting multiple linear regression models.
Learned how to evaluate regression models using R², Adjusted R², and RMSE.
Improved ability to convert statistical results into practical recommendations.
Understood the importance of not confusing correlation with causation.

## Limitations
The dataset may not represent all student populations or education systems.
The regression model may explain only part of the variation in exam performance.
Some important factors, such as teacher quality, mental health, or school resources, may not be fully captured.
Self-reported variables may contain bias or inaccuracies.
Statistical relationships do not prove direct causation.
Model performance could be improved with more features or larger datasets.

## Future Improvements
Use a larger and more diverse student dataset.
Add more variables such as attendance, mental health, school quality, and learning style.
Compare regression with machine learning models such as Random Forest or Gradient Boosting.
Build an interactive dashboard for educators.
Use feature importance or SHAP analysis for better interpretability.
Develop an early-warning system to identify students who may need academic support.
Deploy a simple student performance prediction app using Streamlit.

## How to Run
pip install -r requirements.txt
python main.py

If using a notebook:

jupyter notebook student_academic_performance_modelling.ipynb
