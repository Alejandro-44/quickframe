# Quick Frame
QuicFrame is a Kotlin DSL to create graphical user interfaces based on Java Swing. 
This DSL allows you:

- Define some elements of the user interface, such as buttons, text fields, checkboxes, etc. 
This can be done using an intuitive and easy to understand syntax.

- define different properties for each element.
For example, background color, font size and position on the screen.

- define events using buttons

This DSL avoids the use of `.` and `()`. Although in some occasions it will be necessary.

The main idea of this DSL is defined components similar to CSS, so you are going to define 
components properties line by line. 

## Preview

```kotlin
val form = buildForm {
    properties {
        it background Color(200,200,200)
    }

    label("title","My First QuickForm") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 35)
            it color Color(90, 90, 90)
        }
        grid position Point(0,0)
        grid spanX 2
        grid margin Insets(10,10, 0, 10)
    }

    label("lblName","Name") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(0,1)
        grid margin Insets(10, 10, 0, 0)
    }

    textInput("inName") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(1, 1)
        grid fill GridBagConstraints.HORIZONTAL
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }

    label("lblPassword","Password") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(0, 2)
        grid margin Insets(10, 10, 0 ,0)
    }

    passwordInput("inPassword") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(1, 2)
        grid fill GridBagConstraints.HORIZONTAL
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }

    button("btnSend","Send") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
        }
        grid position Point(0,3)
        grid spanX 2
        grid fill GridBagConstraints.HORIZONTAL
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

To start using QuickFrame first you must define the frame, where you will put our forms. 
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
        it background Color(200, 200, 200)
    }
    label("lblName","Name") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(0,1)
        grid margin Insets(10, 10, 0, 0)
    }

    textInput("inName") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(90, 90, 90)
        }
        grid position Point(1, 1)
        grid fill GridBagConstraints.HORIZONTAL
        grid weightX 1.0
        grid margin Insets(10, 10, 0, 10)
    }
}
```

## Tutorial