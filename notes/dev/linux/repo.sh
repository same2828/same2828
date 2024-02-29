#!/usr/bin/env bash
# Shell Script to clone + copy all branches of a git repository into a single export folder
previous_pwd="$HOME/files"
# Firstly git clone repo into '$HOME/files' and replace "docker-crash-course" with repo name
REPO="$HOME/files/typescript-tutorial"
EXPORT_DIR="$HOME/files/copy"

rm -rf $EXPORT_DIR
mkdir -p $EXPORT_DIR

cd $REPO

for branch in $(git branch -a | grep -P 'remotes/origin/(?!HEAD)'); do
  echo "branch = $branch"
  name=$(echo $branch | sed 's/remotes\/origin\///')
  echo $name
  git checkout origin/$name
  cp -r ./ $EXPORT_DIR/$name
  cd $EXPORT_DIR/$name
  rm -rf .git
  cd $REPO
done

cd $previous_pwd

# for branch in $(git branch -a | grep -P 'remotes/origin/(?!HEAD)'); do
#   # echo "branch = $branch"
#   # Using built in shell parameter expansion
#   name=${branch/remotes\/origin\//}
#   # echo $name
#   # git checkout origin/$name
#   # cp -R ./ $EXPORT_DIR/$name
# done
