# nbp

> Application responsible for conversion of the average purchase price and standard deviation for the sales rate for the given currency and date range. 

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [License and Author](#license-and-author)

## General info

U can run this application with following command: 
  
  java pl.parser.nbp.MainClass EUR 2013-01-28 2013-01-31 
  
Where:
 * first param is one currency code available from (USD, EUR, CHF, GBP) 
 * second and third are dates which describe date range of currency tables

Example result is output: 

  4,1231 - average for given buy rates from currency tables
  0,0123 - standard deviation for given sell rates from currency tables
 
## Technologies
* Java 8
* JUnit 4
* Maven 

## Features

* Integrate with NBP course tables
* Calculating average for given buy rates
* Calculating standard deviation for given sell rates

## License and Author

- Author: Wojciech Skubała ([skubala.wojciech@gmail.com](mailto:skubala.wojciech@gmail.com))

```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
