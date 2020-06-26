import tkinter as tk
from tkinter import ttk

import ViewController as VC

win = tk.Tk()
win.wm_minsize(width=800, height=600)
win.title("ChapelScan")

# Tab Control introduced here -----------------------------------------
tabControl = ttk.Notebook(win)          # Create Tab Control

scanInTab = ttk.Frame(tabControl)
tabControl.add(scanInTab, text="Scan-In")

scanOutTab = ttk.Frame(tabControl)
tabControl.add(scanOutTab, text="Scan-Out")
tabControl.pack(expand=1, fill="both")  # Pack to make visible
# ~ Tab Control introduced here -----------------------------------------

# Scan-In Page ----------------------------------------------------------
scanInContainer = ttk.Frame(scanInTab)
scanInContainer.grid(column=0, row=0)

# Textbox Entry Widget
scanInText = ttk.Entry(scanInContainer, width=120, textvariable=VC.cardReqID)
scanInText.grid(column=0, row=0, padx=20, pady=20)

# Button
scanInButton = ttk.Button(scanInContainer, text="Scan In")
scanInButton.grid(column=1, row=0, padx=20)
# /Scan-In Page ---------------------------------------------------------

# Scan-Out Page ----------------------------------------------------------

# /Scan-Out Page ---------------------------------------------------------

# Run
win.mainloop()
