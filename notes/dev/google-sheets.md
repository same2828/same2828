# Table of Contents

- [Table of Contents](#table-of-contents)
- [Formula](#formula)
- [Code Snippet](#code-snippet)
- [Regex](#regex)

# Formula

```
=IMPORTXML("https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html", "//div[@aria-labelledby='method-summary-table-tab0']")
=IMPORTXML("https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Character.html", "//div[@id='method-summary-table-tab0']")
```

# Code Snippet

- Google sheets function to split every three columns of a row into a new row

```js
function splitEveryThreeColumns() {
  var sheet = SpreadsheetApp.getActive().getActiveSheet();
  var range = sheet.getDataRange();
  var values = range.getValues();
  var newValues = [];
  var numRows = range.getNumRows();
  var numCols = range.getNumColumns();
  var numNewRows = Math.ceil(numCols / 3);

  for (var i = 0; i < numRows; i++) {
    var row = values[i];
    for (var j = 0; j < numNewRows; j++) {
      var newRow = [];
      for (var k = 0; k < 3; k++) {
        var colIndex = j * 3 + k;
        if (colIndex < numCols) {
          newRow.push(row[colIndex]);
        } else {
          newRow.push('');
        }
      }
      newValues.push(newRow);
    }
  }

  sheet.clearContents();
  sheet.getRange(1, 1, newValues.length, newValues[0].length).setValues(newValues);
}
```

# Regex

```sh
# Find
^"(.+)\n
# Replace
$1;
```

```sh
# Find
\."
# Replace
Leave empty
```

```sh
# Find
\.\n
# Replace
\n
```
