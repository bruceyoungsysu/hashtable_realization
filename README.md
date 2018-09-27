# Hashtable

The class is called `Hashtable`,  you can initialize it wih the following code:

```java
Hashtable h = new Hashtable();
h.inithash(5);
```

If there is no size passed to `inithash()` the size of hashtable will be automatically set to 10.

Then you can insert element to the hashtable with the following code:

```java
h.inserthash(key, value);
```

For example:

```java
h.inserthash("1", "sss");
h.inserthash("1","bbb");
h.inserthash("2","qqq");
h.inserthash("2","vvv");
h.inserthash("3","fff");
h.inserthash(0,"ccc");
```

If the hashtable is more than 75% full, then the size of hashtable will be doubled. If you check the hashtable size of the above example

```java
System.out.println(h.hash.size());
```

The output will be

```java
10
```

You can iterate the hastable with following code

```java
h.iteratehash((k,v)->{
            System.out.format("key: %s, value:%s \n", k, v);
        })
```

The output will be

```java
key: 2, value:qqq 
key: 2, value:vvv 
key: 3, value:fff 
key: 0, value:ccc 
key: 1, value:sss 
key: 1, value:bbb
```
