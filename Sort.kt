/**
 * Kotlin code for search and sort algorithms
 * TECOC340
 * Coded with love by Siddharth..
 */
import java.util.*

class Sort {
    internal var pass: Int = 0
    internal var m: Int = 0
    internal var n: Int = 0
    internal var tmp: Int = 0

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val size: Int
            var ch: Int
            var searchElem: Int
            print("Enter the size of the array: ")
            val sin = Scanner(System.`in`)
            size = sin.nextInt()
            println(" ")
            val arr = IntArray(size)
            println("Enter the elements: ")
            for (i in 0 until size) {
                print("Enter element at index $i : ")
                arr[i] = sin.nextInt()
            }
            println(" ")
            println("Array before sort: ")
            for (i in 0 until size) {
                print(" " + arr[i])
            }
            val ob1 = AscendSort()
            val ob2 = DescendSort()
            val ob3 = SearchAlgo()
            var cho = 1
            do {
                println(" ")
                println("Sort array in:  ")
                println("1)Ascending Order")
                println("2)Descending Order")
                println("3)Search Element")
                print("Choice: ")
                ch = sin.nextInt()
                println(" ")
                when (ch) {
                    1 -> {
                        ob1.AscSort(arr)
                        println("Array after sorting in Ascending order: ")
                        for (i in arr.indices) {
                            print(" " + arr[i])
                        }
                        println()
                    }

                    2 -> {
                        ob2.DscSort(arr)
                        println("Array after sorting in Descending order: ")
                        for (i in arr.indices) {
                            print(" " + arr[i])
                        }
                        println()
                    }

                    3 -> {
                        println("Enter the element to be searched: ")
                        searchElem = sin.nextInt()
                        ob3.SearchElem(searchElem, arr)
                    }

                    else -> println("Enter a correct option!")
                }
                println(" ")
                print("Do you want to repeat?(1/0): ")
                cho = sin.nextInt()
                println()
            } while (cho == 1)
            sin.close()
        }
    }
}

internal class AscendSort {
    fun AscSort(arr: IntArray) {
        val si = Sort()
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (j == arr.size - 1) {
                    si.pass = 1
                } else {
                    si.m = arr[j]
                    si.n = arr[j + 1]
                    if (si.m > si.n) {
                        si.tmp = arr[j]
                        arr[j] = arr[j + 1]
                        arr[j + 1] = si.tmp
                    }
                }
            }
        }
    }
}

internal class DescendSort {
    fun DscSort(arr: IntArray) {
        val si = Sort()
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (j == arr.size - 1) {
                    si.pass = 1
                } else {
                    si.m = arr[j]
                    si.n = arr[j + 1]
                    if (si.m < si.n) {
                        si.tmp = arr[j]
                        arr[j] = arr[j + 1]
                        arr[j + 1] = si.tmp
                    }
                }
            }
        }
    }
}

internal class SearchAlgo {
    fun SearchElem(s: Int, arr: IntArray) {
        var flag = 0
        val `as` = AscendSort()
        `as`.AscSort(arr)
        val midElemIndex = arr.size / 2
        val midElem = arr[midElemIndex]
        if (s == midElem) {
            flag = 1
        }
        if (s > midElem) {
            for (i in midElemIndex until arr.size) {
                if (s == arr[i]) {
                    flag = 1
                }
            }
        }
        if (s < midElem) {
            for (i in midElemIndex downTo 0) {
                if (s == arr[i]) {
                    flag = 1
                }
            }
        }
        if (flag == 1) {
            println()
            println("Search operation successful, element $s found.")
        } else {
            println()
            println("Search operation unsuccessful, element $s not found")
        }
    }
}

