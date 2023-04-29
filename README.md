# Quick Frame
A Kotlin DSL to create graphical user interfaces with Java Swing

## Preview

```kotlin
val form = buildForm {
    properties {
        it background Color(200, 200, 200)
    }

    label("Name") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(50,50,50)
            it preferredSize Dimension(210, 20)
        }
        grid position Point(0,0)
        grid paddingY 40
        grid margin Insets(10, 10, 0, 0)
    }

    val IName = textInput {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(0,0,0)
            it preferredSize Dimension(210, 20)
        }
        grid position Point(1, 0)
        grid paddingY 40
        grid margin Insets(10, 10, 0, 0)
    }

    label("Password") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(50,50,50)
            it preferredSize Dimension(210, 20)
        }
        grid position Point(0,1)
        grid paddingY 40
        grid margin Insets(10, 10, 0, 0)
    }

    val IPassword = password {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(0,0,0)
            it preferredSize Dimension(210, 20)
        }
        grid position Point(1, 1)
        grid margin Insets(10, 10, 0, 0)
    }

    button("Enviar") {
        properties {
            it fontFamily Font(Font.DIALOG, Font.BOLD, 25)
            it color Color(0,0,0)
            it preferredSize Dimension(430, 20)
        }
        grid position Point(0, 2)
        grid spanX 2
        grid paddingY 40
        grid margin Insets(10, 10, 0, 0)

        onClick {
            IPassword.text = ""
            IName.text=""
        }
    }
}
```

## QuickStart

## Tutorial