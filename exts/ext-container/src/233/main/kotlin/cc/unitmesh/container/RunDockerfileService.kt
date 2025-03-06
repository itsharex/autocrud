package cc.unitmesh.container

import cc.unitmesh.devti.provider.RunService
import com.intellij.docker.dockerFile.DockerLanguage
import com.intellij.execution.configurations.RunProfile
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.runReadAction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import kotlinx.coroutines.runBlocking

class RunDockerfileService : RunService {
    override fun isApplicable(project: Project, file: VirtualFile): Boolean = file.name == "Dockerfile" ||
            file.isValid && runReadAction { PsiManager.getInstance(project).findFile(file)?.language == DockerLanguage.INSTANCE }

    override fun runConfigurationClass(project: Project): Class<out RunProfile>? = null

    override fun runFile(project: Project, virtualFile: VirtualFile, psiElement: PsiElement?, isFromToolAction: Boolean)
            : String? {

        ApplicationManager.getApplication().invokeAndWait {
            runBlocking {

            }
        }

        return null
    }
}