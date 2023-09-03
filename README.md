# Quick Frame
QuickFrame is a Kotlin DSL to create graphical user interfaces based on Java Swing. 
This DSL allows you:

- Define some elements of the user interface, such as buttons, text fields, checkboxes, etc. 
This can be done using an intuitive and easy to understand syntax.

- define different properties for each element.
For example, background color, font size and position on the screen.

- define events using buttons

This DSL avoids the use of `.` and `()`. Although on some occasions it will be necessary.

The main idea of this DSL is defined components similar to CSS, so you are going to define 
component properties line by line. 

## Install

To install this DSL you must download [quickframe.jar](https://github.com/Alejandro-44/quickframe/releases/tag/v0.1.0) and add it in a directory.

## Preview

```kotlin
val form = buildForm {
    properties {
        it background Color(200,200,200)
    }

    label("title") {
        properties {
            it text "My First QuickFrame"
            it fontFamily Font(Font.DIALOG, Font.BOLD, 35)
        }
        grid position Point(0,0)
        grid spanX 2
        grid margin Insets(10,10, 0, 10)
    }

    label("lblName") {
        properties {
            it text "Name"
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
        }
        grid position Point(0,1)
        grid margin Insets(10, 10, 0, 0)
    }

    textInput("inName") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
        }
        grid position Point(1, 1)
        grid fill horizontal
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }

    label("lblPassword") {
        properties {
            it text "Password"
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
        }
        grid position Point(0, 2)
        grid margin Insets(10, 10, 0 ,0)
    }

    passwordInput("inPassword") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
        }
        grid position Point(1, 2)
        grid fill horizontal
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }

    button("btnSend") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it text "Send"
        }
        grid position Point(0,3)
        grid spanX 2
        grid fill horizontal
        grid margin Insets(10, 10, 0, 10)
        onClick {
            getInputText("inName")?.text = ""
            getInputPassword("inPassword")?.text = ""
        }
    }
}

val frame = buildFrame {
    properties {
        it size Dimension(500,500)
        it title "My First QuickFrame"
        it onClose EXIT
        it resizable false
        it addToCenter form
    }
}

fun main() {
    frame.isVisible = true
}
```

## QuickStart

To start using QuickFrame, first you must define the frame, where you will put our forms. 
For this, you use `buildFrame` function to define a new frame from Java Swing (in this DSL is known as `QFrame`)
and bound it in a variable.

```kotlin
val frame = buildFrame { //returns a QFrame object
    properties {
        it size Dimension(500,500) // Dimensions in pixels
        it title "My First QuickFrame" // Frame's title
        it onClose EXIT // Action on close
        it resizable false // not is resizable
    }
}

fun main() {
    frame.isVisible = true // to make visible
}
```
As you can see `buildFrame` receives a lambda function, and it executes code from `QFrame` class.
So, in `buildFrame` you can call the method `propertires`, where you can define some common properties 
of a `JFrame` from Java Swing. Finally, to make this frame visible you set `isVisible` property to `true`.

In this DSL the most important object is `QForm`. There you will put all interactive components like fields or buttons.
For this you use `buildForm` function that returns a `QForm` instance.

```kotlin
val form = buildForm {
    properties {
        // background color
        it background Color(200, 200, 200)
    }
    
    // adding label component
    label("lblName") // label id 
    {
        //properties for label component
        properties {
            it text "Name"
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        //position in layout
        grid position Point(0,1)
        //margin in layout
        grid margin Insets(10, 10, 0, 0)
    }
    
    // adding a text field component
    textInput("inName") // text input id
    {
        //properties for a text field component
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        //position in layout
        grid position Point(1, 1)
        grid fill horizontal
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }
}
```

To add components to the form, you must invoke methods that have 
the same name as the component you want to add. In this DSL you 
can use the following methods:

| Function        | Component adding                                                                           |
|-----------------|--------------------------------------------------------------------------------------------|
| `label`         | Add a `QLabel` instance, the component where you can add text or images.                   |
| `textInput`     | Add a `QTextField` instance, you use this component to receive input data from the user.   |
| `passwordInput` | Add a `QPasswordField` instance, you use this component to receive passwords from user.    |
| `checkbox`      | Add a `QCheckBox` instance, you use this component to create lists of options.             |
| `radioButton`   | Add a `QRadioButton` instance, you use this component to create lists of options.          |
| `button`        | Add a `QButton` instance, you use this component to create and execute events on the frame |
| `comboBox`      | Add a `QComboBox` instance, you use this component to create drop-down lists options.      |

For each component, you must define its id, a unique identifier to refer to the component later on. 
Next, you need to open branches and invoke `properties` method.
Here, you can define various attributes for the component. 
Additionally,
you must specify its position within the QForm layout using the grid object and a Point object from Java's AWS library. 
The default layout for QForm is GridBagLayout from Java,
so you should define the position as you would refer to positions in a matrix. 
Moreover, you can define additional properties for the component in the layout, such as weight, span, fill, etc

## Tutorial

### Building GUIs

For this tutoria, you have to download the file [quickframetutorial.zip](https://github.com/Alejandro-44/quickframe/tree/main/docs/tutorial) and in `/src/main/kotlin/view` create the gile `view.kt`,
in this file you are going to build the following GUI:

![](/docs/images/tutorialGUI.png)

To start, you are going to build the frame with `buildFrame` function from `utils.builders`, this function returns
a `QFrame` instance, so you can bind it by a variable called `frame`.
Receive a lambda function as a parameter, and in kotlin you just can open braces and define the function
there you will make our frame.

```kotlin
val frame = buildFrame {
    //define your frame here
}
```

When you define this parameter, you have access to `QFrame` class, so you have access to
its methods too.
Have the `properties` method where you define certain properties for
the frame.
The properties you can define are:

| Property    | Effect                                                                                                                   |
|-------------|--------------------------------------------------------------------------------------------------------------------------|
| `size`      | Define the size of frame, it is measured in pixels. It receives a `Dimension` object from `java.awt`.                    |
| `resizable` | Define if frame can change its size or not. It receives a boolean value.                                                 |
| `onClose`   | Define action that the program will do when frame is closed. It action could be: `EXIT`, `DISPOSE`, `HIDE` or `NOTHING`. |
| `location`  | Define initial position for frame on screen. It receives a `Point` object from `java.awt`.                               | 

For this tutorial, you are going to define the following properties:

```kotlin

val frame = buildFrame {
    properties {
        it size Dimension(750, 700) //750x700 pixels
        it resizable false //not resizable
        it onClose EXIT //end the program when the frame is closed
        it location Point(293, 0) //initialize in x=293 and y=0
    }
}
```

To visualize this frame, you use the `isVisible` attribute on the main function:

```kotlin
val frame = buildFrame {
    properties {
        it size Dimension(750, 700) //750x700 pixels
        it resizable false //not resizable
        it onClose EXIT //end the program when the frame is closed
        it location Point(293, 0) //initialize in x=293 and y=0
    }
}

fun main() {
    frame.isVisible = true //when execute the frame will appear
}
```

Now you are going to add some components in our frame.
The layout is the way how frame adds components.
By default, frame has `BorderLayout` and it works as follows:

![](/docs/images/BorderLayoutTutorial.png)

You can use methods from `QFrame` that add components in its respective areas, those methods are: `addToTop`,
`addToCenter`, `addToBottom`, `addToRight` and `addToLeft`, each one receives a component.
Whe you add a component on this layout, it will cover all available space.

```kotlin
val frame = buildFrame {
    properties {
        it size Dimension(750, 700)
        it resizable false 
        it onClose EXIT 
        it location Point(293, 0) 
    }
    addToTop(component)
    addToCenter(component)
    addToBottom(component)
    addToRight(component)
    addToLeft(component)
    
}

fun main() {
    frame.isVisible = true //when execute the frame will appear
}
```

Now you are going to build the components for this GUI. First of all, you are going to build the header:

![](/docs/images/tutorialHeader1.png)

you can think the header like a component divide in two subcomponents, the image and a form with general
information

![](/docs/images/tutorialHeader2.png)

To create a component with two subdivisions you use `formsGroup`, it allows creating groups of components.
By default, a group has a `GridLayout`, with this you can create as many subcomponents as you like.
But grid has a problem because it adds the components so that each one occupies the same space,
and if you see, the header image is greater than the information panel.
To solve this problem, you can change the layout to `BorderLayout`, with this layout
the components occupy the space that they need.

```kotlin
val headerGroup = formsGroup {
    properties { //the same method that you find in buildFrame
        it layout BorderLayout() //change layout to BorderLayout
    }
}

```

To add the header image you have to create a form with `buildForm` from `utils.builders`, it returns an instance of `QForm`, this is the most
important object in this DSL, is the object where you put all components you need. When you invoke this function it works
in the same way as `buildFrame` works, you open braces and use methods from `QForm` class.

```kotlin
val headerImage = buildForm {
    label("image") { //must initialize with ID
        properties {
            it icon "data/images/header.png" // url in the project
        }
    }
}

val headerGroup = formsGroup {
    properties {
        it layout BorderLayout()
    }
    add(headerImage, BorderLayout.CENTER) // add header image in the center
}

```

In `QForm` you have some methods to add different components for our form. The components will add automatically on
the form layout. But you can define exactly position in form layout (you will discuss this later). Components you can
add are the following:

| Function        | Component adding                                                                           |
|-----------------|--------------------------------------------------------------------------------------------|
| `label`         | Add a `QLabel` instance, the component where you can add text or images                    |
| `textInput`     | Add a `QTextField` instance, you use this component to receive input data from the user.   |
| `passwordInput` | Add a `QPasswordField` instance, you use this component to receive passwords from user.    |
| `checkbox`      | Add a `QCheckBox` instance, you use this component to create lists of options.             |
| `radioButton`   | Add a `QRadioButton` instance, you use this component to create lists of options.          |
| `button`        | Add a `QButton` instance, you use this component to create and execute events on the frame |
| `comboBox`      | Add a `QComboBox` instance, you use this component to create drop-down lists options.      |

Each of these methods can invoke the `properties` method to get access to class they refer. In this case, you need
to add a label on the form and put an image there. For this, you use the method `label`, for each component that you add
you must define a unique identifier, and in its properties you use `icon` property that receives the url of the image 
in the project. After in the group you invoke the method `add`, you pass the component and its position in layout that 
it is going to be center.

For the information component, you have to create another form with the next elements:
a label for the total load, a field for the value of the total load, a label for the average load
and a field for the value of the average load.

```kotlin
val informationPane = buildForm {
    // Remember always define IDs
    label("lblTotalLoad") {
        properties {
            it text "Total load:" // define text in label
            it aligntext left // text alignment to left 
        }
    }
    textInput("inTotalLoad") {
        properties {
            it content  "0.00" // initial value
            it editable false // text input not editable
        }
    }
    label("lblAverageLoad") {
        properties {
            it text "Average load:" // define text in label
            it aligntext left // text alignment to left 
        }
    }
    textInput("inAverageLoad") {
        properties {
            it content  "0.00" // initial value
            it editable false // text input not editable
        }
    }
}
```
To add components like on the image, you have to keep in mind of the next information:
a `QForm` instance use `GridBagLayout`.
This layout works like this:

![](/docs/images/GridBagLayoutTutorial.png)

As you can see, there are numbers in horizontal axis (X axis) and in vertical axis (Y axis),
this is for positioning components, so a component in position (0,0) refers to first column and first row.
You can refer to any column and row you want (not until 2 as in image), you can create a grid
with n_th columns and n_th rows.
Also, there are some attributes that you can use to modify component behavior.
Every time you use a method to add a component you have access at `grid` variable from `QForm`
class, and it allows us to set some attributes to grid layout: 

| Attribute   | Effect                                                                                                                                                                                      |
|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `position`  | Specify the position of the element on the layout, it receives a `Point` object form `java.awt`.                                                                                            |
| `posX`      | Specify the position of the element on X axis, it receives an `Int`.                                                                                                                        |
| `posY`      | Specify the position of the element on Y axis, it receives an `Int`.                                                                                                                        |
| `spanX`     | Specify how many columns in the grid a component can cover, it receives an `Int`.                                                                                                           |
| `spanY`     | Specify how many rows in the grid a component can cover, it receives an `Int`.                                                                                                              |
| `paddingX`  | Specify  the internal padding in X axis: how much to add to the size of the component, it receives an `Int`.                                                                                |
| `paddingY`  | Specify  the internal padding in Y axis: how much to add to the size of the component, it receives an `Int`.                                                                                |
| `margin`    | Specifies the external padding of the component, the minimum amount of space between the component and other component. It receives `Insets` object.                                        |
| `fill`      | Specifies the direction in which the component should cover its space, it will cover all the available space it has. It can be `horizontal` or `vertical`.                                  |
| `weightX`   | Specify how components distribute their space among columns, so if a component have have more weightX than other it cover more space. It receives a `Double` object between `0.0` and `1.0` |
| `weightY`   | Specify how components distribute their space among rows, so if a component have have more weightY than other it cover more space. It receives a `Double` object between `0.0` and `1.0`    |

Now you can still build our information panel:

```kotlin
val informationPane = buildForm {
    properties {
        // titledBorder let us add a border with a little title
        it titledBorder "Information" 
    }
    // Remember always define IDs
    label("lblTotalLoad") {
        properties {
            it text "Total load:" // define text in label
            it aligntext left // text alignment to left
        }
        grid position Point(0,0) //position component at first column first row
        grid weightX 0.5 // in the image components cover the same space
        grid weightY 0.5 // in the image components cover the same space
        grid fill horizontal // this ensures that the elements occupy the maximum available space on the x-axis
    }
    textInput("inTotalLoad") {
        properties {
            it content "0.00" // initial value
            it editable false // text input not editable
        }
        grid position Point(1,0) //position component at second column first row
        grid weightX 0.5 // in the image components cover the same space
        grid weightY 0.5 // in the image components cover the same space
        grid fill horizontal // this ensures that the elements occupy the maximum available space on the x-axis
    }
    label("lblAverageLoad") {
        properties {
            it text "Average load:" // define text in label
            it aligntext left // text alignment to left 
        }
        grid position Point(0,1) //position component at first column second row
        grid weightX 0.5 // in the image components cover the same space
        grid weightY 0.5 // in the image components cover the same space
        grid fill horizontal // this ensures that the elements occupy the maximum available space on the x-axis

    }
    textInput("inAverageLoad") {
        properties {
            it content "0.00" // initial value
            it editable false // text input not editable
        }
        grid position Point(1,1) //position component at second column second row
        grid weightX 0.5 // in the image components cover the same space
        grid weightY 0.5 // in the image components cover the same space
        grid fill horizontal // this ensures that the elements occupy the maximum available space on the x-axis
    }
}
```
And you add the information pane to the header group and the header group to frame in top

```kotlin

val headerGroup = formsGroup {
    properties {
        it layout BorderLayout()
    }
    add(headerImage, BorderLayout.CENTER) // add header image in the center
    add(informationPane, BorderLayout.SOUTH) // add information pane in the bottom
}

val frame = buildFrame {
    properties {
        it size Dimension(750, 700)
        it resizable false
        it onClose EXIT
        it location Point(293, 0)
    }
    addToTop(headerGroup) // add the header group in top
}
```

The next step in our tutorial is to build the main section of the GUI.

![](/docs/images/tutorialMain1.png)

You can think the main section is subdivided in four forms, and each one is equals to the other.
So, to build the main section, you are going to use a feature from this DSL, the form template.
To create a template you use `buildTemplate` function from `utils.builders`. A template lets us 
build a structure for a form that you could use in multiple forms.

![](/docs/images/tutorialMain2.png)

To build the main section, you focus on just one form. 
This form contains: one image, four labels each with its own input text and two buttons.

![](/docs/images/tutorialMain3.png)

You have to be careful, the image and buttons don't cover the same space vertically.
So, you have to build a group for each form with `BorderLayout` and build another template for the buttons.
First, you are going to build the pane with information about the truck.

```kotlin
val truckPaneTemplate = buildTemplate {
    //form image 
    label("imgTruck") {
        properties {
            it icon "./data/images/emptyTruck.png"
        }
        grid position Point(0,0) 
        grid spanY 4 //image covers four rows in grid
        grid weightX 0.5 
        grid fill horizontal
    }
    /* Form labels and input text:
    *  - Each one covers the same space in for, so each one has weightX and weightY value of 0.5
    * */
    // Licence plate label 
    label("lblLicensePlate") {
        properties {
            it text "License plate: "
        }
        grid position Point(1,0)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
    
    // Licence plate label value
    textInput("inLicensePlate") {
        properties {
            it content "ABC123"
            it editable false
        }
        grid position Point(2,0)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
    
    // Capacity label
    label("lblCapacity") {
        properties {
            it text "Capacity: "
        }
        grid position Point(1,1)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }


    // Capacity value 
    textInput("inCapacity") {
        properties {
            it content "0.00"
            it editable false
        }
        grid position Point(2,1)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
    
    // Consumption label
    label("lblConsumption") {
        properties {
            it text "Consumption: "
        }
        grid position Point(1,2)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }

    // Consumption value
    textInput("inConsumption") {
        properties {
            it content "0.00"
            it editable false
        }
        grid position Point(2,2)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
    
    // Load label
    label("lblLoad") {
        properties {
            it text "Current load: "
        }
        grid position Point(1,3)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
    
    // Load value
    textInput("inLoad") {
        properties {
            it content "0.00"
            it editable false
        }
        grid position Point(2,3)
        grid weightX 0.5
        grid weightY 0.5
        grid fill horizontal
    }
}
```

Now you have to build buttons template with two buttons:

```kotlin
val buttonsTemplate = buildTemplate {
    button("btnLoad") {
        properties {
            it text "Load"
        }
        grid position Point(0,0)
        grid weightX 0.5
        grid fill horizontal
    }

    button("btnUnload") {
        properties {
            it text "Unload"
        }
        grid position Point(1,0)
        grid weightX 0.5
        grid fill horizontal
        grid margin Insets(0, 10, 0, 0)
    }
}
```
The next step is to build each form and each buttons panel for its form.
To build a form from a template you use `buildForm` and pass as parameter a template.
Then, you have to create each group and add the forms and buttons in the center and the bottom respectively.

```kotlin
// truck panes
val truckPaneA = buildForm(truckPaneTemplate)
val truckPaneB = buildForm(truckPaneTemplate)
val truckPaneC = buildForm(truckPaneTemplate)
val truckPaneD = buildForm(truckPaneTemplate)
// buttons panes
val truckButtonsA = buildForm(buttonsTemplate)
val truckButtonsB = buildForm(buttonsTemplate)
val truckButtonsC = buildForm(buttonsTemplate)
val truckButtonsD = buildForm(buttonsTemplate)

val truckGroupA = formsGroup {
    properties {
        it layout BorderLayout() // change layout to BorderLayout
    }
    add(truckPaneA, BorderLayout.CENTER) // add truckPane in the center
    add(truckButtonsA, BorderLayout.SOUTH) // add buttons in the bottom
}

val truckGroupB = formsGroup {
    properties {
        it layout BorderLayout()
    }
    add(truckPaneB, BorderLayout.CENTER)
    add(truckButtonsB, BorderLayout.SOUTH)
}

val truckGroupC = formsGroup {
    properties {
        it layout BorderLayout()
    }
    add(truckPaneC, BorderLayout.CENTER)
    add(truckButtonsC, BorderLayout.SOUTH)
}

val truckGroupD = formsGroup {
    properties {
        it layout BorderLayout()
    }
    add(truckPaneD, BorderLayout.CENTER)
    add(truckButtonsD, BorderLayout.SOUTH)
}

```

To end the main section, you have to build another group of truck groups.
It consists of a 2x2 grid, so you should use `GridLayout`. 
When you use `formGroup` you can define grid's size and its gap, it refers to the space between components in grid.
The first two parameters define the size, and after you define the horizontal gap and the vertical gap.

```kotlin
// define a 2x2 grid with 5px of horizontal gap and vertical gap.  
val mainGroup = formsGroup(2, 2, 5, 5) {
    // add each truck group
    add(truckGroupA)
    add(truckGroupB)
    add(truckGroupC)
    add(truckGroupD)
}
```

The last section you have to build on this tutorial is the options.
The options section consists of four buttons, then to build it you have to create a form with four buttons

![](/docs/images/tutorialButtons.png)

```kotlin
val optionsPane = buildForm {
    properties {
        it titledBorder "Options" //add title to section
    }
    button("btnBetterTruck") {
        properties {
            it text "Search the best truck"
        }
        grid position Point(0,0)
        grid weightX 0.5
        grid fill horizontal
    }
    button("btnTotalCapacity") {
        properties {
            it text "Total capacity"
        }
        grid position Point(0, 1)
        grid weightX 0.5
        grid fill horizontal
    }
    button("btnMostLoad") {
        properties {
            it text "Search the most loaded truck"
        }
        grid position Point(1, 0)
        grid weightX 0.5
        grid fill horizontal
    }
    button("btnEmptyTrucks") {
        properties {
            it text "Empty Trucks"
        }
        grid position Point(1, 1)
        grid weightX 0.5
        grid fill horizontal
    }
}
```

You will complete this tutorial adding `mainGroup`, on the top, and `optionsPane`, on the bottom at frame.

```kotlin
val frame = buildFrame {
    properties {
        it size Dimension(750, 700)
        it resizable false
        it onClose EXIT
        it location Point(293, 0)
    }
    addToTop(headerGroup)
    addToCenter(mainGroup)
    addToBottom(optionsPane)
}

fun main() {
    frame.isVisible = true
}
```

### Events

To add events in QuickFrame, we have to use the Button component.
In this version buttons are the only component receives events, specifically on click.
But before, you must add the basic information for interaction of the GUI.
In each case, you are going to create a new function to call them later.
So, first you must create a new instance of
`TransportCompany` in the project:

```kotlin
val transportCompany = TransportCompany()
```

Now on the information pane, you can load information of the total
load and the average load of the trucks. We can extract the information from the transport company object directly and put it in the inputs of information.
For this, you can access to an input component with `getInputText` method and pass ID of the component as argument.
Then, you use `text` property to assign the text of that input. So, in the transport company object you can get
the information using `getTotalLoad` and `getAverageLoad` methods.

```kotlin
/*
* ------------------------- LOAD DATA -----------------------------
* */
fun addInformation() {
    informationPane.getInputText("inTotalLoad")!!.text = transportCompany.getTotalLoad().toString() + " Kg"
    informationPane.getInputText("inAverageLoad")!!.text = transportCompany.getAverageLoad().toString() + " Kg"
}

```

After you have to load information for each truck panel. Firstly, you can store all truck panels in an array.
Then, you can use the same process you use before to add information to the information pane, but in this case
you can access to each truck of the company using the `trucks` property that contains each truck object from
the company. So, using a cycle you can put the information.

```kotlin
val truckPanes = arrayOf(truckPaneA, truckPaneB, truckPaneC, truckPaneD)
fun addTrucks() {
    for (i in 0 until 4) {
        val pane = truckPanes[i] // select a pane
        pane.getInputText("inLicensePlate")!!.text = transportCompany.trucks[i].licensePlate // add license info
        pane.getInputText("inCapacity")!!.text = transportCompany.trucks[i].capacity.toString() + " Kg" // add capacity info
        pane.getInputText("inConsumption")!!.text = transportCompany.trucks[i].consumption.toString() + " gal/km" // add consumption info
        pane.getInputText("inLoad")!!.text = transportCompany.trucks[i].currentLoad.toString() + " Kg" // add current load info
    }
}
```

Now comes the longest task, create the events and actions.
To add an action when a button is clicked, you can use the method `onClick`.
This lets you perform any action you want on the GUI.
Also, you can get a button with `getButton` method and the ID.
So you have to store the button panels in an array and access each one by a cycle
and create define actions.

```kotlin
/*
* --------------------------------- LOAD EVENTS ----------------------------
* */

val buttonPanes = arrayOf(truckButtonsA, truckButtonsB, truckButtonsC, truckButtonsD)

fun configureEvents() {
    for (i in 0 until 4) {
        val buttonPane = buttonPanes[i] // select a button pane
        val truck = transportCompany.trucks[i] // select a truck
        val pane = truckPanes[i] // select a truck pane
        
        // define action when click load button
        buttonPane.getButton("btnLoad")!!.onClick {
            val weight = inputMessage(null, "Load").toInt() // create an input dialog to get the weight of the load
            // load selected truck
            transportCompany.loadTruck(pane.getInputText("inLicensePlate")!!.text, weight)
            // get the image label and change image when load the truck
            pane.getLabels("imgTruck")!!.icon("./data/images/loadedTruck.png") 
            // get load input and set the new current load as value
            pane.getInputText("inLoad")!!.text = truck.currentLoad.toString() + " kg"
            // update information panel
            addInformation()
            // unable load button
            buttonPane.getButton("btnLoad")!!.isEnabled = false
            // enable unload button
            buttonPane.getButton("btnUnload")!!.isEnabled = true

        }
        buttonPane.getButton("btnUnload")!!.onClick {
            // unload selected truck
            transportCompany.unloadTruck(pane.getInputText("inLicensePlate")!!.text)
            // change image when unload
            pane.getLabels("imgTruck")!!.icon("./data/images/emptyTruck.png")
            // get load input and set the new current load as value
            pane.getInputText("inLoad")!!.text = truck.currentLoad.toString() + " kg"
            // update information panel
            addInformation()
            // enable load button
            buttonPane.getButton("btnLoad")!!.isEnabled = true
            // unable unload button
            buttonPane.getButton("btnUnload")!!.isEnabled = false
        }
    }
}
```

Another important aspect in this topic is the messages.
QuickFrame has functions to launch messages for errors, warnings and inputs.
In this case, you use `inputMessage` function to create an input dialog.
To add these configurations to your GUI, you must call the previous function within the frame variable.

```kotlin
val frame = buildFrame {
    properties {
        it size Dimension(750, 700)
        it resizable false
        it onClose EXIT
        it location Point(293, 0)
    }
    addToTop(headerGroup)
    addToCenter(mainGroup)
    addToBottom(optionsPane)
    addInformation() // add information
    addTrucks() // add truck's information
    configureEvents() // add events
}
```

Finally, you have to define the actions for buttons in the options panel.
For this you can use the method `onClick` and methods from the truck company instance.

```kotlin
val optionsPane = buildForm {
    properties {
        it titledBorder "Options" //add title to section
    }
    button("btnBetterTruck") {
        properties {
            it text "Search the best truck"
        }
        grid position Point(0,0)
        grid weightX 0.5
        grid fill horizontal
        onClick { // defining new action
            val weight = inputMessage(null, "load weight: ").toInt() // create input dialog and get input as an integer
            informationMessage(
                null,
                "The most loaded Truck is: " + transportCompany.getBestTruck(weight)?.licensePlate, // show a message dialog with the license plate of the best truck
                "Most loaded truck")
        }
    }
    button("btnTotalCapacity") {
        properties {
            it text "Total capacity"
        }
        grid position Point(0, 1)
        grid weightX 0.5
        grid fill horizontal
        onClick {
            informationMessage(
                 null,
                "The most loaded Truck is: " + transportCompany.getTotalCapacity().toString(), // show the total capacity of the company
                "Most loaded truck")
        }
    }
    button("btnMostLoad") {
        properties {
            it text "Search the most loaded truck"
        }
        grid position Point(1, 0)
        grid weightX 0.5
        grid fill horizontal

        onClick {
            informationMessage(
                 null,
                "The most loaded Truck is: " + transportCompany.truckMostLoadedLicensePlate(), // show the most loaded truck in the company
                "Most loaded truck")
        }
    }
    button("btnEmptyTrucks") {
        properties {
            it text "Empty Trucks"
        }
        grid position Point(1, 1)
        grid weightX 0.5
        grid fill horizontal
        onClick {
            informationMessage(
                null,
                "Number of empty truck: " + transportCompany.quantityTrucksUnloaded(), // show how many trucks are empty
                "Empty Trucks"
            )
        }
    }
```

Now you can interact with the GUI!