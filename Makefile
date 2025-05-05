JAVAC = javac
JAVA = java
SRC = $(wildcard *.java)
CLASSES = $(SRC:.java=.class)
MAIN = main

all: $(CLASSES)

%.class: %.java
	$(JAVAC) $<

run: all
	$(JAVA) $(MAIN)

clean:
	del /Q *.class