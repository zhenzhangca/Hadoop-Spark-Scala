#Spark project
##Set up Java and JDK
Validate them with `java -version` & `javac -version` in terminal or cmd.  
##Why need Java and JDK
Scala, Spark and many other technologies require Java and JDK to develop and build the applications. Scala is JVM based programming language.  
##Set up Scala with Intellij
Install Scala plugin
##Develop Hello world program
See `com.spark.HelloWorld.scala`.  
##Set up sbt and run application
Once the application is developed, we need to build jar file and migrate to higher environments. sbt is the build tool which is typically used for Scala based projects.  

Program takes 3 arguments  
args(0) -> execution mode  
args(1) -> input path  
args(2) -> output path  
Running the application  
Go to Run menu -> Edit Configurations  
Add new application  
Give application name GetRevenuePerOrder  
Choose main class: retail_db.GetRevenuePerOrder  
Program arguments: `local <input_path> <output_path> ` 
Use classpath for module: Choose scalasparkdemo  
Click on Apply and then Ok  
Then run the application by right clicking and choosing Run “GetRevenuePerOrder”  
Go to output path and check files are created for output or not  
##Build jar file with sbt
Install sbt with `brew install sbt` in terminal  
Validate with `which sbt` 
Run `sbt package` to build jar file  
Then you will find the jar file under `scalasparkdemo/target/scala-2.11/classes ...`  
Run `sbt "run-main retail_db.GetRevenuePerOrder local <input_path> <output_path>"`  
The result is same as running with IDEA.  
##Setup Environment variables on Mac/Linux
Why??? Regularly, go to the `bin` directory of `spark-xxx-bin-hadoop2.7`, then run `./spark-shell`, spark will be running.  
Setting up environment variables is to run spark-submit, spark-shell from anywhere on the local machine using jar file.  
How??? Navigate to the directory of `spark-xxx-bin-hadoop2.7` -> Setup new environment variable SPARK_HOME and update PATH.  
Run `export SPARK_HOME = /Users/XXX/spark-3.0.0-bin-hadoop2.7`  and `export PATH=$PATH:$SPARK_HOME/bin`  
Go to any directory and run spark-shell to validate.  
However,  when you restart the terminal, run `spark-shell`, `command not found`, because the envs are temporarily exported. In order to make them permanently, we have to add them into `.bash_profile`file.  
`ls -altr|grep profile`->`vi .bash_profile`...



