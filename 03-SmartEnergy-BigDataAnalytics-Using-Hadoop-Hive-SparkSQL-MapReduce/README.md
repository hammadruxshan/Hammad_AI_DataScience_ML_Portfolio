# 03 - Smart Energy Big Data Analytics Using Hadoop, Hive, Spark SQL and MapReduce

## Abstract
This project explores how big data technologies can be used to support smart energy management through large-scale batch analysis of hourly electricity demand data. Energy consumption data is time-based and can grow significantly over long periods, making it suitable for distributed storage and processing tools. By analysing long-term energy demand patterns, organisations can better understand peak load behaviour, usage trends, operational inefficiencies, and opportunities for sustainability improvements.

The purpose of this project was to design and demonstrate a scalable big data analytics workflow using Hadoop-based technologies. HDFS was used for distributed data storage, Hive was used for SQL-style batch querying, Spark SQL was used for efficient analytical processing, and Hadoop MapReduce was implemented for distributed aggregation. The analysis focused on daily energy totals, peak load patterns, weekday versus weekend usage, tool performance comparison, and energy consumption insights.

This project demonstrates practical exposure to big data architecture, distributed storage, batch processing, SQL-based analytics, performance comparison, and smart energy decision support. It also highlights how big data tools can help transform raw electricity demand data into meaningful insights for operational planning, sustainability, and future forecasting.

## Problem Statement

Energy consumption data is generated continuously and can become difficult to process efficiently using traditional single-machine tools. Organisations need scalable systems that can store, query, aggregate, and analyse large volumes of time-indexed energy data.

This project addresses the need for a scalable big data solution that can process long-term hourly electricity demand data and generate useful insights for smart energy management.

## Objectives
To analyse hourly electricity consumption data using big data technologies.
To ingest and store the dataset using HDFS.
To perform batch analytics using Hive.
To perform faster analytical processing using Spark SQL.
To implement Hadoop MapReduce for distributed aggregation.
To compare tool performance across Hive, Spark SQL, and MapReduce.
To interpret energy usage patterns and provide recommendations.

## Dataset / Input
The dataset used in this project was the AEP_hourly.csv dataset from the Hourly Energy Consumption collection. It contained hourly electricity demand readings from American Electric Power.

Key dataset attributes included:

Datetime: Timestamp of the electricity demand reading.
AEP_MW: Electricity demand measured in megawatts.

The dataset covered multiple years of hourly records and was suitable for analysing time-based energy patterns such as daily total demand, peak load periods, hourly trends, and weekday/weekend differences.

## Methodology
1. Data Collection
The hourly energy consumption dataset was obtained and reviewed to understand its structure, time range, and variables.
2. HDFS Ingestion
The dataset was uploaded into HDFS to demonstrate distributed storage and large-scale data handling.
3. Hive Implementation
Hive tables were created and SQL-style queries were used to calculate energy usage summaries such as daily total demand and peak load.
4. Spark SQL Implementation
Spark SQL was used to run analytical queries and compare processing performance with Hive.
5. MapReduce Implementation
Hadoop MapReduce was implemented using Java to perform scalable aggregation such as daily total energy and peak load calculations.
6. Performance Comparison
Hive, Spark SQL, and MapReduce were compared based on query execution, processing approach, and suitability for different workloads.
7. Visualisation and Interpretation
Energy consumption patterns and tool performance results were visualised and interpreted.
8. Recommendations and Conclusion
Recommendations were provided on how big data technologies can support smart energy analytics and operational decision-making.

## Technologies Used
Hadoop
HDFS
Hive
HiveQL
Spark SQL
Hadoop MapReduce
Java
SQL
Big data batch processing
Distributed storage
Energy analytics
Data visualisation

## Results

The project demonstrated how different big data tools can process the same energy dataset using different approaches.

Key findings:

HDFS provided scalable distributed storage for time-indexed energy data.
Hive allowed SQL-style batch analytics over the dataset.
Spark SQL was useful for faster analytical processing and iterative querying.
MapReduce demonstrated the fundamentals of distributed batch aggregation.
Tool performance varied depending on workload type and processing design.
Energy consumption analysis helped identify demand patterns and peak load behaviour.

Add screenshots of Hive queries, Spark SQL output, MapReduce output, and performance comparison chart here.

## Screenshots / Visualisations

Suggested visuals to add:

HDFS file upload screenshot
Hive table creation screenshot
Hive query output
Spark SQL query output
MapReduce execution output
Tool performance comparison chart
Daily energy demand visualisation
Peak hour analysis graph
Weekday vs weekend energy pattern graph

## Key Learnings
Learned how HDFS stores data across a distributed environment.
Understood how Hive simplifies querying big data using SQL-style syntax.
Gained experience using Spark SQL for analytical processing.
Practised implementing MapReduce for scalable aggregation.
Learned how to compare big data tools based on performance and use case.
Understood how big data analytics can support energy management and sustainability.

## Limitations
The dataset contained only two main fields, limiting deeper analysis.
The analysis focused on batch processing rather than real-time streaming.
External variables such as weather, holidays, and carbon intensity were not included.
The project was mainly a demonstration of tool usage rather than a production-scale energy platform.
More complex forecasting or anomaly detection models could improve insight generation.

## Future Improvements
Add weather, holiday, and seasonal data for richer analysis.
Store curated data in Parquet or ORC format for better performance.
Use Spark MLlib for demand forecasting or anomaly detection.
Build a dashboard for energy consumption monitoring.
Extend the pipeline to support real-time data streams using Kafka or Spark Streaming.
Improve partitioning by year, month, and day for faster time-range queries.
Deploy the workflow in a cloud-based big data environment.

## How to Run

Example setup commands may vary depending on your Hadoop environment.

hdfs dfs -mkdir /energy_data
hdfs dfs -put AEP_hourly.csv /energy_data

For Hive:

CREATE TABLE energy_consumption (
    datetime STRING,
    AEP_MW INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE;

For Spark SQL:

spark-submit energy_analysis.py

For MapReduce:

javac EnergyAggregation.java
hadoop jar EnergyAggregation.jar EnergyAggregation /energy_data/AEP_hourly.csv /energy_output
