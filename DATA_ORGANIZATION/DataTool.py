import numpy as np

class GesturesObject:

    def __init__(self, filename, dataframe):
        self.filename = filename
        self.dataframe = dataframe



    def __str__(self):
        print("Data from participant_gestures/", self.filename)
        print(self.dataframe)