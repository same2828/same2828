'use strict';

import { WriteStream, createWriteStream } from 'fs';
process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString: string = '';
let inputLines: string[] = [];
let currentLine: number = 0;

process.stdin.on('data', function (inputStdin: string): void {
  inputString += inputStdin;
});

process.stdin.on('end', function (): void {
  inputLines = inputString.split('\n');
  inputString = '';

  main();
});

function readLine(): string {
  return inputLines[currentLine++];
}

/*
 * Complete the 'stockPairs' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY stocksProfit
 *  2. LONG_INTEGER target
 */

function stockPairs(stocksProfit: number[], target: number): number {}

function main() {
  const ws: WriteStream = createWriteStream(process.env['OUTPUT_PATH']);

  const stocksProfitCount: number = parseInt(readLine().trim(), 10);

  let stocksProfit: number[] = [];

  for (let i: number = 0; i < stocksProfitCount; i++) {
    const stocksProfitItem: number = parseInt(readLine().trim(), 10);

    stocksProfit.push(stocksProfitItem);
  }

  const target: number = parseInt(readLine().trim(), 10);

  const result: number = stockPairs(stocksProfit, target);

  ws.write(result + '\n');

  ws.end();
}
