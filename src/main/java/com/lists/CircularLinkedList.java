/*
 * File: CircularLinkedList.java
 * Author: Prakhar Shrivastava
 * Date: 27 Aug, 2016
 * -----------------------------------------
 * CircularLinkedList is a generic data structure to store data items
 * of any type in a continuous list fashion.
 */
package com.lists;


import java.util.Iterator;

/*
* LinkedList provides following API
        * ----------------------------------------------
        *         CircularLinkedList ()                   // constructs a empty list. O(1)
        * int     getSize()                      // returns the length of list in integer. O(1)
        * boolean isEmpty()               // returns true if list is empty, false otherwise. O(1)
        * void    add(Item item)      	   // append an item in the last of list. O(1)
        * void    add(Item item, int index)  //append an item at the given index in the list. O(n)
        * Item    get(int index)             // returns the item at the given index from the list. O(n)
        * boolean remove(int index)	   // remove the node and return true at the given index from the list. O(n)
        * Iterator<Item> iterator()   	   // Iterate over the linkedList
        *
*/

public class CircularLinkedList<Item> implements Iterable<Item>{
    LinkedListNode head, tail;
    int size;

    /**
       * creates new empty
       * CircularLinkedList
     */

    public CircularLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    /**
       * returns the size of
       * CircularLinkedList
     */

    public int getSize(){
        return size;
    }

    /**
       * checks is the
       * list is empty
     */

    public boolean isEmpty(){
        return size == 0;
    }

    /**
       * add item to the last
       * of the list
     */

    public void add(Item item){
        LinkedListNode linkedListNode = new LinkedListNode(item);
        if(isEmpty()){
            head = linkedListNode;
            tail = linkedListNode;
        }
        else{
            tail.next = linkedListNode;
            tail = linkedListNode;

        }
        linkedListNode.next = head;
        size++;
    }

    /**
       * add item at the
       * specified index
     */

    public void add(Item item, int index)throws IndexOutOfBoundsException{
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }

        LinkedListNode linkedListNode = new LinkedListNode(item);

        if(index == size - 1){
            add(item);
        }

        else if(index == 0){
            linkedListNode.next = head.next;
            head = linkedListNode;
            size++;
        }

        else {
            LinkedListNode start = head;
            while (index != 1) {
                index--;
                start = start.next;
            }

            linkedListNode.next = start.next;
            start.next = linkedListNode;
            size++;
        }

    }

    /**
       * returns the item
       * at the specified index
     */

    public Item get(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            return head.item;
        }

        else if(index == size - 1){
            return tail.item;
        }

        else{
            LinkedListNode start = head;
            while (index != 0) {
                index--;
                start = start.next;
            }

            return start.item;
        }
    }

    /**
       * remove the item at the
       * specified index
     */

    public void remove(int index) throws IndexOutOfBoundsException{
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }

        if(index == 0){
            head = head.next;
            tail.next = head;
        }

        else{
            LinkedListNode start = head;
            int temp = index;
            while(temp != 1){
                temp--;
                start = start.next;
            }

            start.next = start.next.next;

            if(index == size - 1){
                tail = start;
            }

            size--;
        }
    }

    /**
       * returns an iterator
       * to list
     */

    public Iterator<Item> iterator(){
        return new CircularLinkedListIterator();
    }

    class CircularLinkedListIterator implements Iterator<Item> {
        private LinkedListNode current = head;

        public boolean hasNext(){
            return true;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
    class LinkedListNode{
        Item item;
        LinkedListNode next;

        LinkedListNode(Item item){
            this.item = item;
            next = null;
        }
    }
}
