# Table of Contents

- [Table of Contents](#table-of-contents)
- [Google Search Tips/Tricks](#google-search-tipstricks)
- [Google Scholar](#google-scholar)
- [Force Reload](#force-reload)
- [Firefox Bookmark Keywords](#firefox-bookmark-keywords)
  - [Google Web Search](#google-web-search)
  - [Google Web Search + `site:reddit.com`](#google-web-search--siteredditcom)
  - [Google Web Search + `site:stackoverflow.com`](#google-web-search--sitestackoverflowcom)
  - [DuckDuckGo Search](#duckduckgo-search)
  - [YouTube](#youtube)

# Google Search Tips/Tricks

> Note: Need to enable Verbatim via Tools > All results > Verbatim to get below to work
> `"https://www.google.com/search?tbs=li:1&q=%s"`

- Use double quotes `""` to get an `"EXACT"` match
- Use `site:` to search within a specific site
- Use `BEFORE:`, `AFTER:` to filter with date ranges (e.g. `react tutorial AFTER:2023`)
- Use `filetype:` to search for a particular filetype
- Use `-site:pinterest.*` to exclude a site from search result
- Use `-term` to exclude a term from search result
- Use wildcard `*` to make searches (e.g. `the * of money`)
- Use `imagesize:500x500` to search for images of a particular size

| Command         | Description                                       | Example                                                                |
| --------------- | ------------------------------------------------- | ---------------------------------------------------------------------- |
| `""`            | Double quotes = Exact Match                       | `"react tutorial"`                                                     |
| `-`             | Minus/Dash = Exclusion                            | `-pinterest`, `-site:pinterest.*`, `-inurl:pinterest`, `-filetype:xml` |
| `*`             | Wildcard                                          | `learn * tutorial`                                                     |
| `~`             | Tilde = Synonyms                                  | `react ~classes` (lessons, tutorials)                                  |
| `AND`           | Logical AND                                       | `react AND nextjs`                                                     |
| `OR` or `\|`    | Vertical Bar = Logical OR                         | `react OR nextjs`, `react \| nextjs`                                   |
| `BEFORE:yearX`  | Time Period Before                                | `movies BEFORE:2019`                                                   |
| `AFTER:yearX`   | Time Period After                                 | `movies AFTER:2019`                                                    |
| `yearA..yearB`  | Time Period Range                                 | `movies 2000..2010`                                                    |
| `site:x`        | Search within specific site, domain, country code | `site:reddit.com`, `site:org OR site:edu`, `site:AU`                   |
| `location:x`    | Filter results within specific location           | `festival location:taipei`                                             |
| `filetype:x`    | Filter by certain file type                       | `filetype:pdf`                                                         |
| `allinurl:x`    | Find search term in the url                       |                                                                        |
| `allintext:x`   | Find search terms in the text of the page         |                                                                        |
| `allintitle:x`  | Find search terms in the html title of that page  |                                                                        |
| `allinanchor:x` | Find search terms in the links                    |                                                                        |

Examples:

```sh
site:nytimes.com ~college "test scores" -SATS 2008..2010
filetype:pdf air speed intitle:velocity of *swallow
```

# Google Scholar

Examples:

```sh
author:green photosynthesis "leaf"
```

# Force Reload

| Shortcut                            | Description  |
| ----------------------------------- | ------------ |
| `Cmd + Shift + R`                   | Force Reload |
| `Ctrl + Shift + R`                  | Force Reload |
| `Ctrl + F5`                         | Force Reload |
| `Hold Shift && Click Reload Button` | Force Reload |

Note: `Cmd + R` or `F5` only does normal reload

# Firefox Bookmark Keywords

`Chrome > chrome:settings > Search Engine > Manage Search Engines and Site Search > Site Search > Add`

`Firefox > Ctrl + Shift + O/Command + Shift + O > ${dummyBookmark} > URL + Keyword`

## Google Web Search

Keyword = `g`

Flags:

- Web = `udm=14`
- Verbatim = `tbs=li:1`
  - Note: The benefits of this is questionable

```js
javascript:(function(){n=0;q='search?&tbs=li:1&q=';p='';u='https://www.google.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){n=0;q='search?&tbs=li%3A1&q=';p='';u='https://www.google.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){n=0;q='search?&udm=14&q=';p='';u='https://www.google.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){n=0;q='search?&udm=14&tbs=li:1&q=';p='';u='https://www.google.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){n=0;q='define.php?term=';p='';u='https://www.urbandictionary.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){n=0;q='results?q=';p='';u='https://www.youtube.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
javascript:(function(){q='?q=';p='kp=-2';u='https://duckduckgo.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,%22_blank%22)}else{location=u}})();
```

```
https://www.google.com/search?q=%s&udm=14&tbs=li:1+site%3Areddit.com
https://www.google.com/search?q=%s&udm=14&tbs=li%3A1+site%3Areddit.com

https://www.google.com/search?udm=14&tbs=li:1&q=%s+site%3Astackoverflow.com+OR+site%3Asuperuser.com+OR+site%3A*.stackexchange.com+OR+site%3Aaskubuntu.com+OR+site%3Aserverfault.com
https://www.google.com/search?udm=14&tbs=li%3A1&q=%s+site%3Astackoverflow.com+OR+site%3Asuperuser.com+OR+site%3A*.stackexchange.com+OR+site%3Aaskubuntu.com+OR+site%3Aserverfault.com

https://www.google.com/search?udm=14&q=%s+site%3Astackoverflow.com+OR+site%3Asuperuser.com+OR+site%3A*.stackexchange.com+OR+site%3Aaskubuntu.com+OR+site%3Aserverfault.com
```

```sh
https://www.google.com/search?q=%s&tbs=li:1
https://www.google.com/search?q=%s&tbs=li%3A1
https://www.google.com/search?q=%s&udm=14
https://www.google.com/search?q=%s&udm=14&tbs=li:1
https://www.google.com/search?q=%s&udm=14&tbs=li%3A1
```

Read more

- https://www.reddit.com/r/google/comments/1ff9jcg/tip_use_google_web_verbatim_search_as_default/
- https://old.reddit.com/r/firefox/comments/o3yfeo/just_discovered_firefox_bookmark_keywords_you_can/

## Google Web Search + `site:reddit.com`

Keyword = `r`

```sh
https://www.google.com/search?udm=14&q=%s+site%3Areddit.com
https://www.google.com/search?udm=14&tbs=li:1&q=%s+site%3Areddit.com
```

## Google Web Search + `site:stackoverflow.com`

Keyword = `s`

```sh
https://www.google.com/search?udm=14&q=%s+site%3Astackoverflow.com
https://www.google.com/search?udm=14&tbs=li:1&q=%s+site%3Astackoverflow.com

https://www.google.com/search?udm=14&q=%s+site%3Astackoverflow.com+OR+site%3Asuperuser.com+OR+site%3A*.stackexchange.com+OR+site%3Aaskubuntu.com+OR+site%3Aserverfault.com
https://www.google.com/search?udm=14&q=%s+site%3Astackoverflow.com+OR+site%3Asuperuser.com+OR+site%3Aapple.stackexchange.com+OR+site%3Aaskubuntu.com+OR+site%3Aserverfault.com+OR+site%3Ameta.stackexchange.com
```

## DuckDuckGo Search

Keyword = `d`

Flags:

- Safe Search OFF = `kp=-2`

```js
javascript:(function(){q='?q=';p='kp=-2';u='https://duckduckgo.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
```

```sh
https://duckduckgo.com/?kp=-2&q=%s
```

## YouTube

Keyword = `yt`

```js
javascript:(function(){n=0;q='results?q=';p='';u='https://www.youtube.com/';d='q|p|query|search|term|search_query|as_q'.split('|');a=[];s='%s';c=location.search.slice(1).split('&');t=window.getSelection().toString();n=t?1:0;if(s=='%'+'s'||s=='')s=t;for(i%20in%20c){k=c[i].split('=');for(j%20in%20d){if(k[0]==d[j]&&k[1])a.push(escape(k[1]))}}t=unescape(a.join('%20').replace(/\+/g,'%20'));s=s?s:t;if(s){u+=q+s+(p?'&'+p:p)}else{u=(p?u+'?'+p:u)}if(n){window.open(u,"_blank")}else{location=u}})();
```
