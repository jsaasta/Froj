FILE_PATH = ./com/jsaasta/froj
FILE_PATH_STDLIB = $(FILE_PATH)/stdlib
FILE_PATH_STDLIB_SOCKET = $(FILE_PATH_STDLIB)/socket
FILE = ../hello_world.froj
FILE_NAME_JAR = froj.jar

all: run

compile:
	rm -f $(FILE_PATH)/*.class
	javac -d ./ $(FILE_PATH)/*.java $(FILE_PATH_STDLIB)/*.java $(FILE_PATH_STDLIB_SOCKET)/*.java
	jar -cfm $(FILE_NAME_JAR) ./META-INF/MANIFEST.MF $(FILE_PATH)/*.class $(FILE_PATH_STDLIB)/*.class $(FILE_PATH_STDLIB_SOCKET)/*.class
	rm -f $(FILE_PATH)/*.class
	rm -f $(FILE_PATH_STDLIB)/*.class
	rm -f $(FILE_PATH_STDLIB_SOCKET)/*.class

clean:
	rm -f $(FILE_PATH)/*.class
	rm -f ./$(FILE_NAME_JAR)
	rm -f $(FILE_PATH_STDLIB)/*.class
	rm -f $(FILE_PATH_STDLIB_SOCKET)/*.class

javac:
	javac -d ./ $(FILE_PATH)/*.java

jar:
	jar -cfm $(FILE_NAME_JAR) ./META-INF/MANIFEST.MF $(FILE_PATH)/*.class

run:
	java -jar $(FILE_NAME_JAR) $(FILE)