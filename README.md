# Project #: Project Name

* Author: Zach Christensen
* Class: CS321 Section #002
* Semester: Spring 25

## Overview

This project compares to open adressing techniques, Linear Probing and Double Hashing.
It also implements tests to verify performance under different circumstances.

## Reflection

This project started out really hard for me. I went in to this project
not having a very good grasp on how hash tables work, but the nature
of this project forced me to become very comfortable with them.

This project also helped refresh some old ideas that I learned in previous
classes. Some ideas that it helped refresh were rules of inheritance and 
how to write to a file. Once I got over the initial hump of this project
I really enjoyed it.

## Compiling and Using

javac HashtableExperiment.java
`java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]`

## Results 

## Data Source 1: Random Numbers

| Load Factor | Linear Probing Avg. Probes | Double Hashing Avg. Probes |
| ----------- | --------------------------- | --------------------------- |
| 0.5         | 1.50                        | 1.39                        |
| 0.6         | 1.75                        | 1.53                        |
| 0.7         | 2.17                        | 1.73                        |
| 0.8         | 2.98                        | 2.01                        |
| 0.9         | 5.76                        | 2.57                        |
| 0.95        | 10.23                       | 3.13                        |
| 0.99        | 54.83                       | 4.63                        |

## Data Source 2: Date Values

| Load Factor | Linear Probing Avg. Probes | Double Hashing Avg. Probes |
| ----------- | --------------------------- | --------------------------- |
| 0.5         | 1.35                        | 1.58                        |
| 0.6         | 1.43                        | 1.80                        |
| 0.7         | 1.56                        | 2.07                        |
| 0.8         | 1.75                        | 2.52                        |
| 0.9         | 2.09                        | 3.28                        |
| 0.95        | 2.32                        | 3.97                        |
| 0.99        | 3.15                        | 5.61                        |

## Data Source 3: Word List

| Load Factor | Linear Probing Avg. Probes | Double Hashing Avg. Probes |
| ----------- | --------------------------- | --------------------------- |
| 0.5         | 0.12                        | 0.12                        |
| 0.6         | 0.11                        | 0.11                        |
| 0.7         | 0.11                        | 0.10                        |
| 0.8         | 0.10                        | 0.10                        |
| 0.9         | 0.10                        | 0.10                        |
| 0.95        | 0.10                        | 0.10                        |
| 0.99        | 0.10                        | 0.09                        |

## Sources used

https://gemini.google.com/
-used for markdown table formatting and twin prime algorithm

----------

