package com.example.arcore

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.PlacementMode
import io.github.sceneview.math.Position

class MainActivity : AppCompatActivity() {


    lateinit var arSceneView: ArSceneView
    var modelNode : ArModelNode? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        arSceneView = findViewById(R.id.arSceneView)





        modelNode = ArModelNode(
            placementMode = PlacementMode.INSTANT,
            hitPosition = Position(x = 0.0f, y = 0.0f, z = -2.0f),
            followHitPosition = true,
            instantAnchor = true
        )

        modelNode?.loadModelGlbAsync(
            context = this@MainActivity,
            glbFileLocation = "model.glb",
            autoAnimate = true,
            scaleToUnits = 0.9f,
            centerOrigin = Position(y = -1.0f),
            onError = {exception ->
                Toast.makeText(this, exception.message.toString(), Toast.LENGTH_SHORT).show()
            },
            onLoaded = {modelInstance ->

            }
        )

        modelNode?.let {
            arSceneView.addChild(it)
        }







    }
}