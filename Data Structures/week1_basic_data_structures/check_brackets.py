# python3

from collections import namedtuple

Bracket = namedtuple("Bracket", ["char", "position"])


def are_matching(left, right):
    return (left + right) in ["()", "[]", "{}"]


def find_mismatch(text):
    opening_brackets_stack = []
    for i, next in enumerate(text,start=1):
        if next in "([{":
            # Process opening bracket, write your code here
            opening_brackets_stack.append([next,i])
        if next in ")]}":
            # Process closing bracket, write your code here
            if not opening_brackets_stack:
                return i
            top=opening_brackets_stack.pop()
            if not are_matching(top[0],next):
                return i

    if opening_brackets_stack:
        top=opening_brackets_stack.pop()
        return top[1]
    return "Success"

def main():
    text = input()
    mismatch = find_mismatch(text)
    # Printing answer, write your code here
    print(mismatch)

if __name__ == "__main__":
    main()
