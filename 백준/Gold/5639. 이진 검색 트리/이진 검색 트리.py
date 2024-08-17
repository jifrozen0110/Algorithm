import sys
sys.setrecursionlimit(10**8)
input=sys.stdin.read().splitlines

class Node:
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None

class BinaryTree:
    def __init__(self):
        self.root=None

    def insert(self,data):
        if self.root is None:
            self.root=Node(data)
        else:
            current_node = self.root
            while True:
                if data < current_node.data:
                    if current_node.left is None:
                        current_node.left = Node(data)
                        break
                    current_node = current_node.left
                else:
                    if current_node.right is None:
                        current_node.right = Node(data)
                        break
                    current_node = current_node.right


    def postorder(self):
        self._postorder(self.root)

    def _postorder(self,current_node):
        if current_node is not None:
            self._postorder(current_node.left)
            self._postorder(current_node.right)
            print(current_node.data)


tree=BinaryTree()


str=list(map(int,input()))

for i in range (len(str)):
    tree.insert(str[i])

tree.postorder()

