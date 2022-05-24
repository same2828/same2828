# Table of Contents

- [Table of Contents](#table-of-contents)
- [document.getElementsByClassName() / document.getElementsByTagName()](#documentgetelementsbyclassname--documentgetelementsbytagname)
- [document.querySelector()](#documentqueryselector)
- [Adding/Removing Classes and Setting Style](#addingremoving-classes-and-setting-style)
- [document.getElementById() and cloning](#documentgetelementbyid-and-cloning)
- [Function within Function](#function-within-function)

# document.getElementsByClassName() / document.getElementsByTagName()

```javascript
document.getElementById('id');

document.getElementsByClassName('class1');
// class1 AND class2
document.getElementsByClassName('class1 class2');
element.getElementsByClassName('class1 class2');

document.getElementsByTagName('p');
element.getElementsByTagName('div');
```

# document.querySelector()

```javascript
document.querySelector('#id');
// First instance
document.querySelector('.class1');
// All instances
const allMatches = document.querySelectorAll('.class1');
for (let match of allMatches) {
  // ...
}
const firstMatch = document.querySelectorAll('.class1')[0];
// class1 AND class2
document.querySelector('.class1.class2');
document.querySelectorAll('.class1.class2');
// class1 OR class2
document.querySelector('.class1, .class2');
document.querySelectorAll('.class1, .class2');

document.querySelector('input[type='checkbox']');
document.querySelectorAll('input[type='checkbox']');
```

# Adding/Removing Classes and Setting Style

```javascript
const element = document.querySelector('#elementID');
const subElement = element.querySelector('.subElement');

element.innerText = 'Hello';

element.setAttribute('id', 'btn-login');
element.removeAttribute('id');

element.classList.add('class1');
element.classList.remove('class2');
element.classList.toggle('valid');
element.classList.replace('oldClass', 'newClass');

element.style.display = 'flex';
element.style.display = 'none';
element.style.backgroundColor = '#FFFFFF';
```

# document.getElementById() and cloning

```javascript
const newError = document.getElementById('template-errorAlert').cloneNode(true);

const ctnr = document.getElementById('container-main');
ctnr.appendChild(newError);
```

# Function within Function

```js
const minCameraCover = (root) => {
  let result = 0;
  // 0 = NOT_MONITORED
  // 1 = MONITORED_NOCAM
  // 2 = MONITORED_WITHCAM

  const dfs = (currNode) => {
    if (!currNode) {
      return 1;
    }

    let l = dfs(currNode.left);
    let r = dfs(currNode.right);

    if (l === 1 && r === 1) {
      return 0;
    } else if (l === 0 || r === 0) {
      result++;
      return 2;
    } else {
      // l === 2 || r === 2
      return 1;
    }
  };

  return dfs(root) === 0 ? result + 1 : result;
};
```
