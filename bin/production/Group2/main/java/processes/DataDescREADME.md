
DISCLAIMER Regarding the DataDescription Class

Init it Maintains a dataset of values of a single variable and computes descriptive statistics based on stored data.

The windowSize property sets a limit on the number of values that can be stored in the dataset.
The default value, INFINITE_WINDOW, puts no limit on the size of the dataset.
This value should be used with caution, as the backing store will grow without bound in this case.
For very large datasets, replace Descriptive Statistics with SummaryStatistics, which does not store the dataset, should be used instead of this class.
If windowSize is not INFINITE_WINDOW and more values are added than can be stored in the dataset, new values are added in a "rolling" manner,
with new values replacing the "oldest" values in the dataset.

Note:This class is not threadsafe. SynchronizedDescriptiveStatistics should replace the DescriptiveStatistics class in DataDescription if concurrent access from multiple threads is required.
