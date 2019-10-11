import os
import pandas as pd

import importlib

from DATA_ORGANIZATION.DataTool import GesturesObject

importlib.import_module("DataTool")

gesture_dataset = list()


def parse_data(participant_file_location):
    """
    Pseudocode:
        1) Go through a folder or individual files with individual's participant gesture data.
        2) Parse the information into structure (maybe implement some OOP)
        3) While this is being done split the participants up into their own individual folder.
    :param participant_file_location:
    :return:
    """
    files_list = os.listdir(participant_file_location)
    columns_gesture_information = ['TIME_STAMP', 'HAND_LEFT_X', 'HAND_LEFT_Y', 'HAND_LEFT_Z', 'HAND_RIGHT_X',
                                   'HAND_RIGHT_Y',
                                   'HAND_RIGHT_Z', 'HEAD_X', 'HEAD_Y', 'HEAD_Z']

    columns_annotations = ['TIME_STAMP', 'OBJECT']

    for files in files_list:
        gesture_dataset.append(GesturesObject(files, pd.read_csv(os.join(participant_file_location, files),
                                                                 header=columns_gesture_information)))


def main():
    parse_data("D:\GAN_RESEARCH\participant_gestures")


main()
