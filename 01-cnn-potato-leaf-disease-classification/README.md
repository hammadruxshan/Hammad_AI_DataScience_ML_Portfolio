# 01 - CNN-Based Potato Leaf Disease Classification

## Abstract

This project focuses on applying deep learning and computer vision to classify potato leaf diseases using image data. Potato crops are vulnerable to diseases such as Early Blight and Late Blight, which can reduce crop yield and cause economic loss if not detected early. Traditional disease identification often depends on manual visual inspection, which can be time-consuming, inconsistent, and difficult in rural or under-resourced farming environments.

The purpose of this project was to design and evaluate a Convolutional Neural Network (CNN) model capable of automatically classifying potato leaf images into three categories: Healthy, Early Blight, and Late Blight. The project involved dataset exploration, image preprocessing, resizing, normalisation, data augmentation, train-validation-test splitting, CNN architecture design, model training, and performance evaluation.

The model was evaluated using classification metrics such as accuracy, precision, recall, F1-score, confusion matrix analysis, and overfitting behaviour. The project also considered limitations such as class imbalance, dataset size, and generalisation challenges. Overall, this project demonstrates practical experience in computer vision, deep learning workflows, image classification, model evaluation, and the application of AI to real-world agricultural problems.

## Problem Statement

Potato leaf diseases can be difficult to detect accurately through manual inspection, especially when symptoms appear visually similar or when expert agricultural support is not available. Delayed or incorrect diagnosis can lead to crop damage, reduced yield, and financial loss for farmers.

This project addresses the need for an automated image-based classification system that can support early detection of potato leaf diseases using deep learning.

## Objectives
To explore and preprocess a labelled potato leaf disease image dataset.
To design and train a CNN model for classifying potato leaves into Healthy, Early Blight, and Late Blight categories.
To apply image augmentation and preprocessing techniques to improve model robustness.
To evaluate model performance using suitable classification metrics.
To identify limitations such as class imbalance, dataset size, and real-world generalisation.

## Dataset / Input

The dataset used in this project was the Potato Plant Diseases Data dataset, publicly available on Kaggle. It contains RGB images of potato leaves labelled into three classes:

- Healthy leaves
- Early Blight
- Late Blight

The images were in JPG format and resized to a consistent input dimension before being passed into the CNN model. The dataset had a class imbalance issue, with significantly fewer Healthy leaf images compared to the disease categories. This was considered during model training and evaluation.

## Methodology
1. Data Collection
The potato leaf image dataset was obtained from Kaggle and organised according to class labels.
2. Data Preprocessing
Images were resized, normalised, and prepared for model training. The dataset was split into training, validation, and testing sets.
3. Data Augmentation
Augmentation techniques such as rotation, zooming, flipping, and transformation were applied to improve model generalisation and reduce overfitting.
4. Model Selection
A Convolutional Neural Network was selected because CNNs are well-suited for image classification tasks and can learn spatial features such as leaf texture, colour patterns, and disease marks.
5. Model Implementation
The CNN model was implemented using Python and deep learning libraries. Layers such as convolutional layers, pooling layers, dropout, and dense layers were used.
6. Model Training
The model was trained using the preprocessed image data. Training callbacks such as EarlyStopping and ReduceLROnPlateau were used to improve training stability and avoid unnecessary overfitting.
7. Evaluation
The trained model was evaluated using classification accuracy, precision, recall, F1-score, confusion matrix analysis, and training/validation performance graphs.
8. Results Interpretation
The results were analysed to understand model strengths, weaknesses, misclassification patterns, and limitations caused by dataset imbalance.

## Technologies Used

- Python
- TensorFlow / Keras
- Convolutional Neural Networks
- NumPy
- Matplotlib
- Image preprocessing
- Data augmentation
- Classification metrics
- Confusion matrix analysis
- Google Colab / Jupyter Notebook

## Results

The CNN model was able to classify potato leaf images into Healthy, Early Blight, and Late Blight categories with strong performance. The evaluation process included accuracy, precision, recall, F1-score, and confusion matrix analysis.

Key findings:

- The model learned visible disease patterns from potato leaf images.
- Data augmentation helped improve generalisation.
- Class imbalance affected the model’s ability to treat all classes equally.
- Accuracy alone was not sufficient, so additional metrics such as precision, recall, F1-score, and confusion matrix analysis were used.


## Screenshots / Visualisations

Sample potato leaf images from each class, CNN architecture diagram, Training vs validation accuracy graph, Training vs validation loss graph, Confusion matrix, Prediction examples

## Key Learnings
Learned how CNNs are applied to real-world image classification problems.
Gained experience in preprocessing image datasets for deep learning.
Understood the importance of data augmentation in reducing overfitting.
Learned why class imbalance can make accuracy misleading.
Practised evaluating models using multiple metrics instead of relying only on accuracy.
Understood the limitations of deploying image classification models in real-world agricultural settings.

## Limitations
The dataset contained class imbalance, especially with fewer Healthy leaf images.
The image dataset may not represent all real-world farming environments, lighting conditions, or potato varieties.
The model was trained on RGB images only and did not include multispectral or time-series plant health data.
The model may struggle with unseen disease stages, mixed infections, or poor-quality images.
More real-world validation would be needed before practical agricultural deployment.

## Future Improvements
Use transfer learning with models such as MobileNet, ResNet, or EfficientNet.
Collect a larger and more balanced dataset.
Improve the model using hyperparameter tuning.
Deploy the model as a Streamlit or web application.
Add Grad-CAM visualisation to show which parts of the leaf influenced the prediction.
Test the model on real-world images captured from farms or mobile phones.

## How to Run

This project is implemented as a Jupyter Notebook.


### 1. Install Required Libraries

```bash
pip install -r requirements.txt
```

### 2. Open the Notebook

```bash
jupyter notebook leaf_classification.ipynb
```

Alternatively, the notebook can be opened and run using Google Colab or Kaggle Notebook.

### 3. Dataset Access

The notebook uses the Kaggle dataset:

```python
hafiznouman786/potato-plant-diseases-data
```

The dataset is downloaded in the notebook using `kagglehub`. If running locally, make sure your Kaggle access is configured properly. If running on Kaggle or Google Colab, the notebook can be executed cell by cell after installing the required dependencies.

### 4. Run the Notebook

Run all cells from top to bottom. The notebook will:

* Import the required libraries
* Download/load the potato plant disease dataset
* Preprocess and resize the images
* Split the dataset into training, validation, and test sets
* Apply data augmentation and class weighting
* Train a CNN model
* Evaluate the model using accuracy, precision, recall, F1-score, and confusion matrix analysis
* Display training history and model performance visualisations

