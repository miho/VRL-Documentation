CSS:	resources/css/vrl-documentation.css

# Defining a Workflow #

### Requirements ###

- VRL-Studio >= 4.0.x
- VRL >= 0.4.1

### Depends on ###

[Creating Your First Project](creating-your-first-project.html)

## Contents ##

In this tutorial you will learn how to

- add methods to an component instance
- define control flows
- define dataflows

## Difficulty Level##

### Difficulty Level ###

Beginner

## Creating a New Project ##

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

If a component class declares more than one method they are usually not shown in the component window. To add a method click on the drop down box, choose a method and click on the *add* button. Add the following methods:

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

To complete the control flow drag a connection from the control flow output of the *Counter* object to the *Stop* object. To do so, first move the *Stop* object from the top to the bottom (see Figure ). Next, drag a connection from the control flow output of the *Counter* object to the *Stop* object (see Figure [Create Connection]).

![Create Connection][]

[Create Connection]: resources/img/create-control-flow-connection-01.png width=450px

## Executing the Control Flow ##

The control flow executes the following methods:
	
	Counter counter = new Counter()
	counter.reset()
	counter.inc()
	counter.getV()

Click on the *Start* button to execute the control flow. The method `getV()` will return `1`.

## Changing Method Order ##

To change the order of the methods of the *Counter*  object you can drag them up and down. Drag the `reset()` method down below the `inc()` method (see Figure [Change Method Order]).

![Change Method Order][]

[Change Method Order]: resources/img/change-method-order-01.png width=450px

If you click the *Start* button again `getV()` returns `0`. The *Counter* component should look as shown in Figure [Changed Method Order].

![Changed Method Order][]

[Changed Method Order]: resources/img/change-method-order-02.png width=450px

## Further Reading ##

--



