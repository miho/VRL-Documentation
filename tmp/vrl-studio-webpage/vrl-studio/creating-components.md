CSS:	resources/css/vrl-documentation.css

# Creating Components #

## Requirements ##

- VRL-Studio >= 4.0.x
- VRL >= 0.4.1

## Depends on ##

[Defining a Workflow](defining-a-workflow.html)

## Contents ##

In this tutorial you will learn how to

- visually create custom components
- use the code editor to create custom components

## Difficulty Level ##

### Difficulty Level ###

Intermediate

## Introduction ##

If you are not interested in the explanation of data flow and control flow, you may skip the introduction and continue with [Creating a New Project].

VRL provides two types of flow connections: data flow connections (see Figure [Data Flow Connection])

![Data Flow Connection][]

[Data Flow Connection]: resources/img/data-flow-connection-01.png width=450px

and control flow connections (see Figure [Control Flow Connection]).

![Control Flow Connection][]

[Control Flow Connection]: resources/img/control-flow-connection-01.png width=450px

### Data Flow ###

A data flow connection describes the data dependencies between methods. Figure [Data Flow Connection] shows two components. Each of them has one method. A control flow connection indicates a data dependency between the two methods. Method `b()` of component 2 depends on the result of method `a()` of component 1.

If you are not familiar with the term *method* think of it as a specific task that takes some *input data* and produces *output data*.

#### Example: ####

	Name:   add
	Input:  a, b
	Taks:   c = a + b
	Output: c

See Figure [Data Dependencies of `add()`] for two `add()` methods that are connected with a data flow connection. The result of the first `add()` method is necessary to invoke the second `add()` method. 

![Data Dependencies of `add()`][]

[Data Dependencies of `add()`]: resources/img/data-flow-connection-02.png width=450px

### Control Flow ###

A control flow connection describes the invocation order of methods, i.e., the execution order of tasks.

>**Note:** Invocation orders of methods can be defined explicitly via control flow connections or implicitly by defining data connections. In many cases however it is necessary to use both, data connections and control flow connections to define a workflow.

## Creating a New Project [Creating a New Project]

1. Start VRL-Studio
2. If a dialog shows up, that asks whether to create or load project, click `Cancel`.
3. Click on `File->New-Project`
4. A file dialog will appear. Choose the destination of your project.

The displayed content should look like this:

![Empty Project][]

[Empty Project]: resources/img/empty-project-01.png width=450px


## Adding a component ##

First, right click on the canvas and click on `Code Templates->Counter` (see Figure [Code Templates])

![Code Templates][]

[Code Templates]: resources/img/code-templates-01.png width=450px

Compile the code by pressing on the *Compile* button. Now, open the *Component Management* window, add the *Counter* component to the canvas and close the code window. The desired result is shown in Figure [Counter Component].

![Counter Component][]

[Counter Component]: resources/img/counter-component-01.png width=450px

## Adding Methods ##

If a component class declares more than one method they are usually not shown in the component window. To add a method click on the drop down box, choose a method and click on the *add* button.

Add the following methods (the order matters!):

- reset()
- inc()
- getV()

The desired result is shown in Figure [Counter Methods].

![Counter Methods][]

[Counter Methods]: resources/img/counter-component-02.png width=450px

## Adding Components to the Control Flow ##

To add the *Counter* object to the control flow drag the end of the yellow connection from the *Stop* object to the control flow input of the the *Counter* object (see Figure [Move Control Flow Connection]).

![Move Control Flow Connection][]

[Move control flow Connection]: resources/img/move-control-flow-01.png width=450px

To complete the control flow drag a connection from the control flow output of the *Counter* object to the *Stop* object. To do so, first move the *Stop* object from the top to the bottom (see Figure ). Next, drag a connection from the control flow output of the *Counter* object to the *Stop* object (see Figure [Create Control Flow Connection]).

![Create Control Flow Connection][]

[Create Control Flow Connection]: resources/img/create-control-flow-connection-01.png width=450px

## Executing the Control Flow ##

The control flow executes the following methods:
	
	Counter counter = new Counter()
	counter.reset()
	counter.inc()
	v1 = counter.getV()

Click on the *Start* button to execute the control flow. The method `getV()` will return `1` (`v1 = 1`).

## Changing Method Order ##

To change the order of the methods of the *Counter*  object you can drag them up and down. Drag the `reset()` method down below the `inc()` method (see Figure [Change Method Order]).

![Change Method Order][]

[Change Method Order]: resources/img/change-method-order-01.png width=450px

If you click the *Start* button again `getV()` returns `0`. The *Counter* component should look as shown in Figure [Changed Method Order].

![Changed Method Order][]

[Changed Method Order]: resources/img/change-method-order-02.png width=450px

## Adding Data Dependencies ##

For the next steps you have to revert the method order by dragging the `reset()` method up. See Figure [Counter Methods] for the correct method order.

Now add a second *Counter* object to the canvas and add the following methods (the order matters!):

- setV()
- inc()
- getV()

Add the object to the control flow. This is done exactly as before. Figure [Two *Counter* objects] shows the desired result.

![Two *Counter* objects][]

[Two *Counter* objects]: resources/img/second-counter-object-added-to-control-flow-01.png width=450px

Now drag a data connection from the output connector of `getV()` of the first *Counter* object to the input connector of the second *Counter* object (see Figure [Create Data Flow Connection]).

![Create Data Flow Connection][]

[Create Data Flow Connection]: resources/img/create-data-flow-connection-01.png width=450px

## Executing the final Workflow ##

The final workflow executes the following methods:
	
	Counter counter1 = new Counter()
	counter1.reset()
	counter1.inc()
	v1 = counter1.getV()

	Counter counter2 = new Counter()
	counter2.setV(1)
	counter2.inc()
	v2 = counter2.getV()

After executing the workflow, the `getV()` method of the first *Counter* object returns `1` (`v1 = 1`). The `getV()` method of the second *Counter* object returns `2` (`v2 = 2`, see Figure [Final Workflow]).

![Final Workflow][]

[Final Workflow]: resources/img/final-workflow-01.png width=450px

## Further Reading ##

- [Version Management](version-management.html)



