groupPartners.jar: CS210_HW1.class	
	jar cfe groupPartners.jar CS210_HW1 CS210_HW1.class
	
jar: CS210_HW1.class	
	jar cfe groupPartners.jar CS210_HW1 CS210_HW1.class
	
run: groupPartners.jar
	java -jar groupPartners.jar
	
CS210_HW1.class: CS210_HW1.java
	javac CS210_HW1.java

pdf: CS210_HW1.java
	enscript --color=1 -C -Ejava -1 -o CS210_HW1.ps CS210_HW1.java && ps2pdf CS210_HW1.ps  
