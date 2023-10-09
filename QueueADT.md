# Queue

Stores items of QueueItemType (Generics).

## +createQueue()
create an empty queeu

## +isEmpty() : boolean
Determines whether or not the queue is empty.

## +peek() : QueueItemType
Retrieves the item at the front of the queue without
removing the item from the queue. Throw an exception if the queue is empty.

## +enqueue(item : QueueItemType) 
Adds a new item to the end of the queue. 

## +dequeue() : QueueItemType
Retrieves and removes the item at the front of the queue. Throws an exception when the queue is empty.

## +dequeueAll()
removes all items from the queue