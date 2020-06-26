import tkinter as tk
from tkinter import ttk

students = dict()
scans = dict()
cardReqID = 0

def populateStudents(filename):
    """Populates the students dictionary from file passed in"""
    pass


class Table:
    rows = 0
    cols = 0

    def __init__(self, root):
        for i in range(rows):
            for j in range(cols):
                self.e = tk.Entry(root, width=20)
                self.e.grid(row=i, column=j)
                self.e.insert(END, scans[i])

if __name__ == "__main__":
    populateStudents()
