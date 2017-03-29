# LeanSearchBar

## Android module to create search bar in your app to filter out strings.

## Usage in Activity file

### Creating SearchBar

```
      SearchBar searchBar = new SearchBar(this);
```

### Creating DataSource from which SearchBar will filter out strings.

```
      DataSource dataSource = new DataSource();
```

### Adding string in DataSource.

```
    dataSource.addToData("Apple");
    dataSource.addToData("Bat");
    dataSource.addToData("Cat");
```

### Creating OnMatchListener when the text input in SearchBar matches certain strings.

```
    OnMatchListener listener = new OnMatchListener() {
        @Override
        public void onMatchResults(List<String> results) {

        }
    });
```

### Showing the SearchBar.

```
    searchBar.show(dataSource,listener);
```
## Screencast

<img src="https://github.com/Anwesh43/LeanSearchBar/blob/master/screencast/leansearchbar.mp4" alt="Demo of SearchBar" width="400" height="700"/>
