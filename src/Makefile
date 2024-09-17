FILE_PATH = ./com/jsaasta/froj
FILE = ../hello_world.froj
FILE_NAME_JAR = froj.jar

all: run

compile:
	rm -f $(FILE_PATH)/*.class
	javac -d ./ $(FILE_PATH)/*.java
	jar -cfm $(FILE_NAME_JAR) ./META-INF/MANIFEST.MF $(FILE_PATH)/*.class
	rm -f $(FILE_PATH)/*.class

clean:
	rm -f $(FILE_PATH)/*.class
	rm -f ./$(FILE_NAME_JAR)

javac:
	javac -d ./ $(FILE_PATH)/*.java

jar:
	jar -cfm $(FILE_NAME_JAR) ./META-INF/MANIFEST.MF $(FILE_PATH)/*.class

run:
	java -jar $(FILE_NAME_JAR) $(FILE)