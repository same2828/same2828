# Table of Contents

- [Table of Contents](#table-of-contents)
- [Resource](#resource)
  - [Angular Course Info README.md](#angular-course-info-readmemd)
    - [MyApp](#myapp)
    - [Development Server](#development-server)
    - [Code Scaffolding](#code-scaffolding)
    - [Build](#build)
    - [Running Unit Tests](#running-unit-tests)
    - [Running End-To-End Tests](#running-end-to-end-tests)
    - [Further Help](#further-help)
- [Folder Structure/Architecture](#folder-structurearchitecture)
  - [Modules](#modules)
  - [Components](#components)
  - [Directives](#directives)
  - [Router](#router)
  - [Pipes](#pipes)
  - [Services](#services)
- [String Interpolation](#string-interpolation)
- [Property Binding](#property-binding)
- [Two Way Binding](#two-way-binding)
  - [ngModel](#ngmodel)
- [Template Reference Variable](#template-reference-variable)
  - [ngClass (Class Binding)](#ngclass-class-binding)

# Resource

- Teddy Smith
  - [YouTube Playlist](https://www.youtube.com/playlist?list=PL82C6-O4XrHdf0LMDVl1Y-4_BFbNmdrGc)
  - [GitHub](https://github.com/teddysmithdev/angular-course/)

```sh
npm install -g @angular/cli
ng analytics disable --global
# Create project
ng new my-app
# Run app
ng serve
```

## Angular Course Info README.md

### MyApp

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 14.0.5.

### Development Server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The application will automatically reload if you change any of the source files.

### Code Scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

### Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory.

### Running Unit Tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

### Running End-To-End Tests

Run `ng e2e` to execute the end-to-end tests via a platform of your choice. To use this command, you need to first add a package that implements end-to-end testing capabilities.

### Further Help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI Overview and Command Reference](https://angular.io/cli) page.

# Folder Structure/Architecture

## Modules

- Group code together
- For building "features"
- Example: "Admin module"
- Lazy loading

## Components

- For UI
- Build reusable components
- Render nested components
- One way data flow
- Immutable state

## Directives

- Component = Controls HTML
- Structure = `ngIf`
- Attribute = `ngModel`
- How you "tap into" lower level DOM

```html
<p *ngIf=='true'>
```

## Router

- Handles URL Changes
- Webpage is NOT actually navigating
- Authorization for web pages

## Pipes

- Transforming data
- Examples: Dates
  - Turn an ISO date into somehting more readable like "Mar 3, 2022"

## Services

- Most important
- In charge of API calls
- Dependency injection
- What makes Angular great

# String Interpolation

**`{{ var }} `**

```ts
// src/app/app.component.ts
import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string;
  num1: number = 1;
  num2: number = 2;
  togglePokemon: boolean = false;

  constructor() {
    this.title = 'seth';
  }
}
```

```html
<!-- src/app/app.component.html -->
<router-outlet></router-outlet>
{{ title }} {{ num1 + num2 }} {{ togglePokemon ? "isPokemon" : "isNotPokemon"}}
```

# Property Binding

**`[]`**

```ts
// src/app/app.component.ts
import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string = 'A Photo of a Golden Retrievers';
  imgSrc: string = 'https://dogtime.com/wp-content/uploads/sites/12/2023/07/GettyImages-1443320682.jpg';

  constructor() {}
}
```

```html
<!-- src/app/app.component.html -->
<router-outlet></router-outlet>
<h1 [innerHtml]="title"></h1>
<img [src]="imgSrc" />
```

# Two Way Binding

**`[()]`** (Known as "Banana Box")

1. Sets a property in your code behind
2. Listens for a DOM element change

## ngModel

- Handles the two-way binding
- Only works on `<input />` and `<textarea></textarea>`

```ts
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, FormsModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
```

```ts
// src/app/app.component.ts
import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  favAnimal: string = 'elephant';
  constructor() {}
}
```

```html
<!-- src/app/app.component.html -->
<router-outlet></router-outlet>
<h1>Two-way binding example</h1>
<!-- When you edit the input box for `favAnimal` the <p></p> element will be updated in real time -->
<input [(ngModel)]="favAnimal" />
<p>{{ favAnimal }}</p>
```

# Template Reference Variable

**`#myRefName`**

- Allows you to extract and share components with other components through a ref name e.g. `#pokemonName`

```ts
// src/app/app.component.ts
import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

interface Nav {
  link: string;
  name: string;
  exact: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  pokemon: string = ''; // pikachu
  constructor() {}

  handleClick(value: any) {
    console.log(value);
  }
}
```

```html
<!-- src/app/app.component.html -->
<router-outlet></router-outlet>
<input type="text" #pokemonName />
<button (click)="handleClick(pokemonName)">Click Template Ref Value</button>
<button (click)="handleClick(pokemonName.value)">Click Template Ref Value</button>
```

## ngClass (Class Binding)

Note: `@` = Decorator
