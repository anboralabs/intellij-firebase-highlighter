# intellij-firebase-highlighter

![Plugin](/images/highlighted.png)

## What is it?
intellij-firebase-highlighter is an Intellij plugin for highlighting firebase rules. 

## How to use it?

- Add plugin to Intellij IDE
- Configure colors

### Add plugin to Intellij IDE

- Clone repo
```sh
git clone https://github.com/anboralabs/intellij-firebase-highlighter
```
```
- Find grammar directory
- FirebaseRules.bnf -> Right click -> Generate Parser Code
- FirebaseRules.flex -> Right click -> Run JFlex Generator
```

- Install from disk
```
- Go to https://github.com/anboralabs/intellij-firebase-highlighter/releases/tag/v1.0.0
- download firebase-syntax-highlighting-1.0-SNAPSHOT.jar
- Plugins -> Install From disk -> choose the file downloaded
```
- Install from plugin store

![Market Place](/images/market_place.png)

- Plugin url

  [Plugin Download](https://plugins.jetbrains.com/plugin/15189-firebase-rules-syntax-highlighter)

### Configure colors

- Editor -> Color Schema -> Firebase Rules

![Color Settings](/images/color_settings.png)


## Credits
The main ideas used here were borrowed from:
- https://github.com/ferronrsmith/intellij-fbp-highlighter
- https://github.com/lark-parser/intellij-syntax-highlighting
- https://github.com/klazuka/intellij-elm

## License
```
MIT License

Copyright (c) 2020 Anbora Labs

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```