# Variables
# =========

# Files
# -----
files = ./src/*.java#--------------<> Sources java 
root = $(shell pwd)#---------------------<> Fouder root

# Drive
# -----
Api = slf4j-api-2.0.9.jar#---------<> Api 
Provd = slf4j-simple-2.0.12.jar:#--<> Provedor
Jdbc = sqlite-jdbc-3.45.1.1.jar#---<> Jdbc sqlite


# Targets
# =======
all: Program

# Build
# -----
Program: $(files)
	javac -d .  $(files); \

# clear
# -----
clear:
	rm *.class

# Execute 
# -------
run:
	java -cp ".:$(Api):$(Provd):$(Jdbc)" Main "jdbc:sqlite:$(root)/data.db"
