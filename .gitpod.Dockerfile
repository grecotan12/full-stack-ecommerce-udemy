FROM gitpod/workspace-mysql
USER gitpod
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 17.0.3-ms && \
    sdk default java 17.0.3-ms && \ 
    npm install -g @angular/cli"