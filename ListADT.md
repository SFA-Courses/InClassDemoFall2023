# ListADT
- create a list
- retrieve (get) an element from the list at a given position
- removing an item from the list at a given position
- add an item to the list at a given position
- find the number of elements on the list
- remove all items from list
- checking if a list is empty or not

## +createList()
Creates an empty list.

## +size() : integer
Returns the number of items that are in the list.

## +isEmpty() : boolean
Returns true when the list is empty (no elements) and false otherwise

## +removeAll() 
Remove all the items in the list (or empty the list).

## +add(index : integer, item : ListItemType)
Inserts an time at the given index if
0 <= index <= size().
If index < size(), items after the inserted list item are shifted to the right. 
Throws an exception if the index is out of bounds.

## +get(index : integer) : ListItemType 
Returns the item at the given index on a list,
if 0 <= index < size().
The list is left unchanged.
Throw an exception if the index is out of bounds.

## +remove(index : integer) 
Removes the item at the given index from the list,
if 0 <= index < size().
If index < size() - 1 (not the last item), then the items are renumbered as follows: index + 1 moves to index; index + 2 moves to index + 1, and so on.
Throw an exception if the index is out of bounds.