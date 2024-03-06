all: Main.class

# Files
# =====
files = ./src/*.java

# Drives Sql
# ==========
drive = ".:data/drive/slf4j-api-2.0.9.jar:./data/drive/slf4j-simple-2.0.12.jar:./data/drive/sqlite-jdbc-3.45.1.1.jar"

# Build java
# ==========
Main.class: $(files)
	javac -d ./class  $(files)

# Execute program
# ===============
run: 
	java -cp "/class/Main"
