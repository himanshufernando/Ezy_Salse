package tkhub.project.ezysales.util

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Buffer
import java.io.FileInputStream

const val BASE_PATH = "src/test/mock-responses/"

fun MockWebServer.enqueueFromFile(path: String) {
    enqueue(MockResponse().setBody(Buffer().readFrom(FileInputStream(BASE_PATH + path))))
}