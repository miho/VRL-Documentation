CSS:	resources/css/vrl-documentation.css

<!--VMM-INDEX=4-->

# Version Management #

### Requirements ###

- VRL-Studio >= 4.0.x
- VRL >= 0.4.1

### Depends on ###

[Creating Your First Project](creating-your-first-project.html)

## Contents ##

In this tutorial you will learn how to

- add a version to the project
- search versions
- open a specific version

## Difficulty Level##

Beginner

## Creating a New Project ##

1. Start VRL-Studio
2. If a dialog shows up, that asks whether to create or load project, click `Cancel`.
3. Click on `File->New-Project from Template->VRL-Tutorial-1`
4. A file dialog will appear. Choose the destination of your project.

The displayed content should look like this:

![Tutorial Project 1][]

[Tutorial Project 1]: resources/img/canvas-with-code-01.png width=450px

## Adding a component ##

First, create the component *Add Integers* by pressing the *compile* button. Open the *Manage Components* window and add the *Add Integers* component from the *Custom* category to the canvas.

>**Note:** compiling a component class implicitly creates a new version.

## Creating a Version ##

Click on `File->Save Project` save the current state of the project. This creates a new version.

>**Note:** if you save the project without making any changes VRL will not create a new version as it detects that the project has not been changed. Hence, the number of versions may differ from the number of times you saved the project.

>**Tip:** to create a version that contains a custom message click on `File->Save Project (with message)`. As versions are searchable you can define custom keywords with makes it easy to switch to specific project states.

##  Switching Versions ##

Click on `File->Manage Versions` to open the *Version Management* window. It should show three versions as shown in Figure [Version Management]

![Version Management 1][]

[Version Management 1]: resources/img/version-management-01.png width=450px

Now switch to version 1 by double clicking on it. VRL-Studio will now ask whether to save the current project state before switching.

![Version Management 2][]

[Version Management 2]: resources/img/version-management-02.png width=450px

As you have just saved the project, press *Discard* in the *Checkout Version* dialog. The project state is exactly as in version 1. The *Add Integers*  component has vanished.

Now open the *Version Management* window and switch back to version 3 by double clicking on it. In the *Checkout Version* dialog press *Discard*. After that, the *Add Integers*  component is visible again. 

## Custom Messages ##

As you have seen in the previous sections, VRL creates version messages automatically. They indicate what has been changed since the last version. This is great as you don't have to care about versioning most of the time. You can search messages by date or by the name of the component that has been added or deleted, etc.

But sometimes it is necessary to define custom messages, e.g., for detailed explanations and short tags, such as `feature xy implemented`. This allows you to search for `feature xy` and switch to the corresponding version.

To define custom messages, save the project by clicking on `File->Save Project (with message)`. After the project has been saved, VRL-Studio will show a message dialog that allows to define a custom message.
## Further Reading ##

--


[<- Back To Help Index](index.html)
