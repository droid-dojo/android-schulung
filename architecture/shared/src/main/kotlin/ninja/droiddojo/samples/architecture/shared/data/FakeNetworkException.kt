package ninja.droiddojo.samples.architecture.shared.data

import java.io.IOException

class FakeNetworkException(
    val code: Int,
    val errorMessage: String,
) : IOException(errorMessage)