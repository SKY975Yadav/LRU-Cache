# LRU Cache 
LRU cache using Linked List HashMap and Using Doubly Linked List HashMap

## Overview
An LRU Cache (Least Recently Used Cache) is a data structure that stores a limited number of items and removes the least recently used item when the cache reaches its capacity. It’s commonly used in scenarios where you need to store a subset of data that is frequently accessed while efficiently removing old or less-used data to make room for new data.

## Key Concepts
1. Cache: A temporary storage that helps reduce the time to access frequently used data by storing a subset of the data.
2. Least Recently Used (LRU): The item that has not been accessed for the longest period of time is the first to be removed when space is needed.

## Operations on LRU Cache
1. get(key): Retrieve the value of the cache for a given key. If the key exists, the value is returned, and the key is marked as recently used. If the key doesn't exist, return -1.
2. put(key, value): Insert or update the value for a given key in the cache. If the key already exists, update its value and mark it as recently used. If the key doesn't exist, add it to the cache. If the cache exceeds its capacity, remove the least recently used item.

## Data Structure Design
1. Doubly Linked List: This is used to track the access order of cache items. Each node in the list represents a key-value pair and is linked to its previous and next nodes.
2. HashMap: This is used to store the keys with their corresponding nodes in the doubly linked list, allowing constant time look-up (O(1)).

## Algorithm :
1. get(key):
   If the key exists in the cache, move it to the front (most recently used).
   If the key doesn't exist, return -1.

2. put(key, value):
   If the key exists, update the value and move it to the front.
   If the key doesn't exist, create a new node, add it to the front, and if the cache exceeds capacity, remove the least recently used item (the node at the tail of the doubly linked list).

## Use Cases for LRU Cache :
1. Memory Management: In systems where limited memory is available, an LRU cache can help store the most frequently accessed data while discarding the least used.
2. Database Query Caching: In database systems, cache frequently queried data and discard rarely used queries.
3. Web Browsers: Caching recently visited websites for quick access.
