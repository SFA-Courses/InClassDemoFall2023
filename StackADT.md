# Stack

The items stored will be Generic.

## Operations

### +createStack()
Creates an empty stack.

### +isEmpty() : boolean
Determines whether a stack is empty.

### +push(newItem: StackItemType) 
Add a new item to the top of the stack.

### +pop() : StackItemType
Retrieves and then removes the top of the stack (item that has been most recently added).
Throws an exception if the Stack is empty.

### +popAll() 
Remove all items from the Stack.

### +peek() : StackItemType
Retrives the top of the stack without altering the stack.
Throws an exception if the Stack is empty.