# suite
Uniwersalny kontener. Mapa pamiętająca kolejność dodawania. Stosuje luźne podejście do typów. 

# Przykłady

W nazewnictwie przyjęto zasadę, że obiekty klasy Subject (czyli tworzonego przez Suite/$uite) dostają prefix '$'.
W przykładach użyto notacji <a href="https://github.com/lpogic/brackettree">BracketTree</a>

## 1. Utwórz zbiór liczb od 1 do 5:
```
1 [] 2 [] 3 [] 4 [] 5
```
## &#x21e9;
```
var $set = Suite.set(1, 2, 3, 4, 5);
```
albo przy statycznym użyciu metod $uite (`import static suite.suite.$uite.*;`):
```
var $set = $(1, 2, 3, 4, 5);
```
## 2. Utwórz listę liczb od 1 do 5:
```
[ 1 ][ 2 ][ 3 ][ 4 ][ 5 ]
```
## &#x21e9;
```
var $list = Suite.add(1, 2, 3, 4, 5);
```
albo przy statycznym użyciu metod $uite (`import static suite.suite.$uite.*;`):
```
var $list = $($(1), $(2), $(3), $(4), $(5));
```
## 3. Utwórz mapę jak poniżej:
```
1 [ a ] 
2 [ b ] 
3 [ c ]
```
## &#x21e9;
```
var $map = Suite.put(1, 'a').put(2, 'b').put(3, 'c');
```
albo przy statycznym użyciu metod $uite (`import static suite.suite.$uite.*;`):
```
var $map = $(
  1, $('a'),
  2, $('b'),
  3, $('c')
);
```
## 4. Utwórz drzewo: 
```
1 [ 1 ] 
2 [ 1 [] 2 ] 
3 [ 1 [] 3 ] 
4 [ 
  1 [] 
  2 [ 1 [] 2 ] 
  4 [] 
]
```
## &#x21e9;
```
var $tree = Suite.put(1, 1)
                 .input(2, Suite.set(1, 2))
                 .input(3, Suite.set(1, 3))
                 .input(4, Suite.set(1)
                                .input(2, Suite.set(1, 2))
                                .set(4));
```
albo przy statycznym użyciu metod $uite (`import static suite.suite.$uite.*;`):
```
var $map = $(
  1, $(1),
  2, $(1, 2),
  3, $(1, 3),
  4, $(1, 2, $(1, 2), 4)
);
```
## 5. Utwórz graf:
```
[ 
  #[ a ]
  [ #b ] 
][ 
  #[ b ]
  [ #c ] 
][ 
  #[ c ]
  [ #a ] 
]
```
## &#x21e9;
```
var $c = Suite.set();
var $b = Suite.inset($c);
var $a = Suite.inset($b);
$c.inset($a);
```
