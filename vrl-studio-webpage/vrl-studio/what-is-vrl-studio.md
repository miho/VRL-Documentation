CSS:	resources/css/vrl-documentation.css

# What is VRL-Studio? #

## Overview ##

VRL-Studio is an innovative Integrated Development Environment (IDE) based on the Java Platform that combines both visual and text-based programming. In contrast to many other Development Environments VRL-Studio Projects are fully functional programs that are developed at run-time. This makes it an ideal environment for rapid prototyping, teaching and experimentation.

A VRL-Project is basically a Java Library (.jar-File) that contains visually defined workflows, source code, compiled classes and optionally project related resources. Each project is under revision control and contains a complete project history that contains all versions of the project.

VRL-Studio is based on the Visual Reflection Library (VRL). VRL enables declarative and fully automated creation of graphical user interfaces from Java objects. To accomplish that, VRL uses the information accessible via the Java Reflection API.

In addition to the automatic generation of user interfaces VRL-Studio supports the definition of *data-flow* and *control-flow* and allows fora certain degree of visual programming.

For text-based programming the language Groovy [^groovy] is used. It supports static typing, dynamic typing and meta programming. The syntax of Groovy is based on Java. Almost any Java code will just work without any changes. Even though Groovy is often used as scripting language, it provides a compiler that creates byte code that is fully compatible with the JVM. Therefore, Groovy classes are accessible via the Java Reflection API.

[^groovy]: <a href=http://groovy.codehaus.org>http://groovy.codehaus.org</a>

Figure [Function Plotter] demonstrates some capabilities of VRL.

![Function Plotter][]

[Function Plotter]: resources/img/functionplotter01.png width=450px

## VRL & Declarative UI Development

VRL provides three types of visual components (see Figure [Component Types]) . An object representation is a container, comparable to a program window that can group several child components. A method representation is a container component inside an object representation. It can also group child components and provides elements for calling the represented method. To represent variable data VRL provides type representations. In most cases they allow interaction with the visualized data.

![Component Types][]

[Component Types]: resources/img/component-types01.png width=450px

To create a graphical user interface in VRL it is only necessary to specify its functionality.

### Example ###

The following code defines a simple Java/Groovy class that provides a method that adds two integer numbers.
	
	class AddIntegers {
		public Integer add( Integer a , Integer b) {
			return a+b;
		}
	}

To create a VRL interface for this class no additional code is required. To categorize classes recent VRL versions may require one additional annotation, e.g., `@ComponentInfo(name=AddIntegers, category="Custom")` that contains the category information.

![Add Integers][]

[Add Integers]: resources/img/add-integers-01.png width=450px

Figure [Add Integers] shows how to define the interface in VRL-Studio.

Manually creating the user interface with Java is much more complicated. Equivalent Java code [^not-shortest]:

	public class Main {
		public static void main( String [] args ) {
			javax.swing.JFrame frame = new javax.swing.JFrame(”Add Integers”);
			frame.setLayout(new java.awt.GridLayout());
			final javax.swing.JTextField input1 = new javax.swing.JTextField();
			final javax.swing.JTextField input2 = new javax.swing.JTextField();
			final javax.swing.JTextField output = new javax.swing.JTextField();
			frame.add(new javax.swing.JLabel(”Integer”));
			frame.add( input1 );
			frame.add(new javax.swing.JLabel(”Integer”));
			frame.add( input2 );
			frame.add(new javax.swing.JLabel(”Result”));
			frame.add( output );
			javax.swing.JButton btn = new javax.swing.JButton(”invoke”);
			btn.addActionListener (new java.awt.event.ActionListener() {
				public void actionPerformed ( java.awt.event.ActionEvent e ) {
					output.setText (new Integer (new Integer( input1.getText()) +
					new Integer(input2.getText())).toString());
				}
			});
			frame.add( btn ) ;
			frame.pack( ) ;
			frame.setVisible ( true );
	 	}
	}

[^not-shortest]: not necessarily the shortest possible implementation

## Further Reading ##

For an introduction on how to create projects, read the tutorial [Creating Your First Project](creating-your-first-project.html).

For an example projects look at the VRL tutorial project. Create a new project from template via
Menu:<br> `File->New Project from Template->VRL-Tutorial-1`.


