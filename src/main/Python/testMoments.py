#!/usr/bin/env python


def test_moments(A):

    arrLength = len(A)

    B = []

    moments = 0
    for i in range(arrLength):
        indexElement = A[i]

        if len(B) < indexElement:
            diff = indexElement - len(B)
            for n in range(diff):
                B +='-'

        B[indexElement-1] = 'X'

        if '-' not in B:
            moments += 1

    print 'No of moments ', moments


if __name__ == "__main__":
    test_moments(A)
