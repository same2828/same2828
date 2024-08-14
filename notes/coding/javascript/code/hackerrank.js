'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function (inputStdin) {
  inputString += inputStdin;
});

process.stdin.on('end', function () {
  inputString = inputString.split('\n');

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/*
 * Complete the 'authEvents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts 2D_STRING_ARRAY events as parameter.
 */

function authEvents(events) {
  // Write your code here
}

function main() {
  const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  const eventsRows = parseInt(readLine().trim(), 10);

  const eventsColumns = parseInt(readLine().trim(), 10);

  let events = Array(eventsRows);

  for (let i = 0; i < eventsRows; i++) {
    events[i] = readLine().replace(/\s+$/g, '').split(' ');
  }

  const result = authEvents(events);

  // ws.write(result + '\n');
  ws.write(result.join('\n') + '\n');

  ws.end();
}
