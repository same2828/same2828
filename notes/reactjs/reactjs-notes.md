# Table of Contents

- [Table of Contents](#table-of-contents)
- [Conditional Rendering](#conditional-rendering)
- [Exporting](#exporting)
- [Map](#map)

# Conditional Rendering

- Version 1

  ```js
  {
    emails.length < 10 && (
      <button
        className='btn btn-primary'
        id='add-more-btn'
        onClick={(event) => {
          const newEmails = [...emails];
          newEmails.push('');
          newEmails.push('');
          setEmails(newEmails);
        }}
      >
        Add More
      </button>
    );
  }
  ```

- Version 2
  ```js
  {
    emails.length < 10 ? (
      <button
        className='btn btn-primary'
        id='add-more-btn'
        onClick={(event) => {
          const newEmails = [...emails];
          newEmails.push('');
          newEmails.push('');
          setEmails(newEmails);
        }}
      >
        Add More
      </button>
    ) : (
      <>No more adding</>
    );
  }
  ```

# Exporting

- Version 1.1

  ```js
  function App() {
    const [emails, setEmails] = React.useState([]);

    const someCss = {
      width: '100%',
      height: '100%',
    };

    const someFunction = (event, index) => {
      const newEmails = [...emails];
      newEmails[index] = event.target.value;
      setEmails(newEmails);
    };

    return (
      <div className="ctnr" style={someCss}>
      <div>
    );
  }

  export default App;
  ```

- Version 1.2

  ```js
  const MyCustomComponent = () => {
    const [emails, setEmails] = React.useState([]);

    const someCss = {
      width: '100%',
      height: '100%',
    };

    const someFunction = (event, index) => {
      const newEmails = [...emails];
      newEmails[index] = event.target.value;
      setEmails(newEmails);
    };

    return (
      <div className="ctnr" style={someCss}>
      <div>
    );
  }

  export default MyCustomComponent;
  ```

- Version 2

  ```js
  export const MyCustomComponent = () => {
    return (
      <div className="ctnr" style={someCss}>
      <div>
    );
  };
  ```

# Map

- `parent.map((item, index) => {})`
- Must give `key` prop to each child

- Example 1

  ```js
  {
    emails.map((email, index) => {
      return <div key={index}>Email: {email}</div>;
    });
  }
  ```

- Example 2

  ```js
  <div className='mb-3' id='email-inputs'>
    {emails.map((email, index) => {
      return (
        <div key={index} class='email-input'>
          <label class='form-label'>Email Address {index + 1}</label>
          <input
            type='email'
            class='form-control'
            placeholder='name@example.com'
            onKeyDown={(event) => {
              const newEmails = [...emails];
              newEmails[index] = event.target.value;
              setEmails(newEmails);
            }}
          />
        </div>
      );
    })}
  </div>
  ```
