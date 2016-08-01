CSS:	resources/css/vrl-documentation.css

<!--VMM-INDEX=2-->

# Creating Your First Project #

### Requirements ###

- VRL-Studio >= 4.0.x
- VRL >= 0.4.1

### Depends on ###

[What is VRL-Studio](what-is-vrl-studio.html)

## Contents ##

In this tutorial you will learn how to

- create a project
- compile source code
- add components to the canvas
- invoking methods

## Difficulty Level ##

Beginner

## Creating a New Project ##

1. Start VRL-Studio
2. If a dialog shows up, that asks whether to create or load project, click `Cancel`.
3. Click on `File->New-Project from Template->VRL-Tutorial 1`
4. A file dialog will appear. Choose the destination of your project.

The displayed content should look like this:

![Tutorial Project 1][]

[Tutorial Project 1]: resources/img/canvas-with-code-01.png width=450px


## Creating a Component ##

In Figure [Tutorial Project 1] the content of the tutorial project is shown. <!--For an overview of the user interface of VRL-Studio see **${USER_INTERFACE}**.-->

### Step 1 ###

To create your first component click on the *compile* button: 

![Step 1: Compile][]

[Step 1: Compile]: resources/img/compile-01.png width=450px

The window should turn dark for a short while. VRL-Studio is compiling the code. After that, a success message will be shown.

> **Note:** If the window turns dark VRL-Studio is busy and cannot process user input. 
 
### Step 2 ###

To display the component on the *canvas* open the component management window. To do so, press `CTRL+SPACE`.  A window (*Manage Components*) should appear:

![Step 2: Component Management 1][]

[Step 2: Component Management 1]: resources/img/component-management-01.png width=450px

To add the component to the *canvas* click on the custom category:

![Step 2: Component Management 2][]

[Step 2: Component Management 2]: resources/img/component-management-02.png width=450px

Now drag the *Add Integers* component to the canvas:

![Step 2: Component Management 3][]

[Step 2: Component Management 3]: resources/img/drag-component-to-canvas-01.png width=450px

At the destination of the drag gesture a window will appear after releasing the mouse button. The new window is the visual representation of component *Add Integers*.

<!--## Understanding the Visualization ##

If you are not interested in programming with VRL-Studio, skip this section and continue with [Invoking Methods].

First, recall the source code:
	
	@ComponentInfo(name="Add Integers", category="Custom")
	class AddIntegers implements Serializable {

    	private static final long serialVersionUID=1;

    	public Integer add(Integer a, Integer b){
        	return a+b;
    	}
	}

The first line `@ComponentInfo(name="Add Integers", category="Custom")` defines the component. Each component has at least a name and a category and optionally a component description. In the *Component Management Window*  each component is identified by its category and name. Component descriptions are accessible via *tooltips*.

After the component info the component class is defined. A component that shall be visualized must implement the `Serializable` interface and define a `serialVersionUID`.

It contains one method `add()` that takes two integer values `a` and `b` and returns the result of `a+b`.-->

## Invoking Methods [Invoking Methods] ##

Enter values to the input visualizations of the component as shown in Figure [Parameter Visualization]. Do not enter values to the output.

![Parameter Visualization][]

[Parameter Visualization]: resources/img/component-visualization-01.png width=450px

Click on the *invoke* button to invoke the method `add(Integer a, Integer b)` (see Figure [Method Invocation]).

![Method Invocation][]

[Method Invocation]: resources/img/method-invocation-01.png width=450px

The inputs will blink green to indicate that the parameter validation was successful. The output will be shown after the method has been invoked.

## Things To Try ##

VRL-Studio contains some small code templates. To compile them, right-click on the canvas to open the canvas menu (popup menu) and choose one of the code templates under `Code Templates->`. Compile the code as shown before.

## Further Reading ##

- [Defining a Workflow](defining-a-workflow.html)


[<- Back To Help Index](index.html)
